package net.celesoft.healthycaller.phoneCall

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.telephony.TelephonyManager
import android.util.Log
import com.firebase.jobdispatcher.*
import net.celesoft.healthycaller.enums.CallState


class PhoneCallReceiver : BroadcastReceiver() {

    companion object {
        private const val PHONE_CALL_TAG: String = "PHONE_CALL_TAG"
        private const val TAG: String = "PHONE_CALL_RECEIVER_TAG"
        private const val MIN_TIME_TO_START = 10
        private const val MAX_TIME_TO_START = 30
    }

    private lateinit var jobDispatcher: FirebaseJobDispatcher

    override fun onReceive(context: Context, intent: Intent) {

        val stateStr: CallState = initCallState(intent)

        val isOutgoingCall: Boolean = intent.action == Intent.ACTION_NEW_OUTGOING_CALL
        val isIncomingCall: Boolean = stateStr != CallState.OFFHOOK && stateStr != CallState.RINGING

        jobDispatcher = FirebaseJobDispatcher(GooglePlayDriver(context))
        jobDispatcher.cancelAll()

        if (stateStr == CallState.OFFHOOK || isOutgoingCall) {
            initPhoneCallJob()

        } else if (!isIncomingCall && !isOutgoingCall) {
            jobDispatcher.cancelAll()
            Log.d(TAG, "jobDispatcher: cancelAll")
        }
    }

    private fun initCallState(intent: Intent): CallState {
        val callState: String? = intent.extras.getString(TelephonyManager.EXTRA_STATE) ?: ""
        return CallState.getCallState(callState)
    }

    private fun initPhoneCallJob() {

        val job: Job = jobDispatcher.newJobBuilder()
                .setTag(PHONE_CALL_TAG)
                .setService(PhoneCallJobService::class.java)
                .setRecurring(true)
                .setTrigger(Trigger.executionWindow(MIN_TIME_TO_START, MAX_TIME_TO_START))
                .setLifetime(Lifetime.FOREVER)
                .setRetryStrategy(RetryStrategy.DEFAULT_LINEAR)
                .build()

        jobDispatcher.schedule(job)
    }
}
