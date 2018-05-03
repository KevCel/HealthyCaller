package net.celesoft.healthycaller

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.telephony.TelephonyManager
import android.util.Log
import net.celesoft.healthycaller.enums.CallState


class PhoneCallReceiver : BroadcastReceiver() {

    override fun onReceive(context: Context, intent: Intent) {
        val outgoingCall : String? = intent.getStringExtra(Intent.ACTION_NEW_OUTGOING_CALL)
        val stateStr: CallState = CallState.getCallState(intent.extras.getString(TelephonyManager.EXTRA_STATE))

        if(!outgoingCall.isNullOrEmpty()){

            Log.d("PhoneCallReceiver", stateStr.state)
        }
    }
}
