package com.ruzzante.notification

import android.app.Service
import android.content.Intent
import android.os.IBinder
import android.util.Log
import com.google.firebase.messaging.FirebaseMessagingService
import com.google.firebase.messaging.RemoteMessage

class MyFirebaseMessagingService : FirebaseMessagingService() {

    private val tag = "FirebaseMessagingServic"

    override fun onMessageReceived(message: RemoteMessage) {
        super.onMessageReceived(message)
        Log.i(tag, message.from.toString())

        if (message.notification != null){
            this.showNotification("1234", message.notification?.title.toString(), message.notification?.body.toString())
        }
    }
}