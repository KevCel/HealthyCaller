package net.celesoft.healthycaller.ui.main

import android.Manifest.permission.READ_PHONE_STATE
import android.content.pm.PackageManager
import android.os.Bundle
import android.support.v4.app.ActivityCompat
import android.support.v7.app.AppCompatActivity
import android.util.Log
import net.celesoft.healthycaller.R

class MainActivity : AppCompatActivity() {

    companion object {
        private const val READ_PHONE_REQUEST: Int = 1
        private val TAG: String = MainActivity.javaClass.simpleName
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        checkPermissions()
    }

    private fun checkPermissions() {
        if (checkCallingPermission(READ_PHONE_STATE) == PackageManager.PERMISSION_DENIED) {
            ActivityCompat.requestPermissions(this, arrayOf(READ_PHONE_STATE), READ_PHONE_REQUEST)
        }
    }

    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<out String>, grantResults: IntArray) {
        Log.d(TAG, "onRequestPermissionsResult".plus(requestCode))
    }
}
