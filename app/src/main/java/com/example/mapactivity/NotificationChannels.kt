package com.example.mapactivity

import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.Context
import android.os.Build

class NotificationChannels(val context: Context) {
    val CHANNEL_1 : String= "Channel1"
    val CHANNEL_2 : String= "Channel2"

    fun createNotificationChannels(){
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O){
            val channel1 = NotificationChannel(
                    CHANNEL_1, "Chanel 1",
                    NotificationManager.IMPORTANCE_HIGH
            )
            channel1.description= "You have one new important notification."
            val channel2 = NotificationChannel(
                    CHANNEL_2, "Chanel 2",
                    NotificationManager.IMPORTANCE_HIGH
            )
            channel1.description= "You have one new general notification."

            val notificationManager = context.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager

            notificationManager.createNotificationChannel(channel1)
            notificationManager.createNotificationChannel(channel2)
        }
    }
}