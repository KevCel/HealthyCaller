package net.celesoft.healthycaller.phoneCall

import android.util.Log
import com.firebase.jobdispatcher.JobParameters
import com.firebase.jobdispatcher.JobService

/**
 * Created by Kevin Celejowski.
 */
class PhoneCallJobService : JobService() {

    companion object {
        private const val TAG: String = "PHONE_CALL_JOB_SERVICE"
    }

    override fun onStartJob(job: JobParameters?): Boolean {
        Log.d(TAG, "onStartJob")
        return false
    }

    override fun onStopJob(job: JobParameters?): Boolean {
        Log.d(TAG, "onStopJob")
        return true
    }
}