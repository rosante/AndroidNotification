package com.ruzzante.notification

import android.annotation.SuppressLint
import android.app.Service
import android.content.Intent
import android.os.IBinder
import android.util.Log
import android.widget.Toast
import com.google.android.gms.tasks.OnCompleteListener
import com.google.firebase.iid.FirebaseInstanceIdReceiver
import com.google.firebase.messaging.FirebaseMessagingService
import com.google.firebase.messaging.FirebaseMessaging

class MyFirebaseInstanceIdService : FirebaseMessagingService() {

    private val TAG = "TOKEN"

    fun getInstance(){
        FirebaseMessaging.getInstance().token.addOnCompleteListener(OnCompleteListener {
            if (!it.isSuccessful) {
                Log.w(TAG, "Fetching FCM registration token failed", it.exception)
            }else{
                Log.i(TAG, it.result.toString())
            }
        })

    }

    override fun onNewToken(token: String) {
        super.onNewToken(token)
        Log.i(TAG, token)

    }
}