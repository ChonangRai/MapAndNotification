package com.example.mapactivity

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat

class NotificationActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_notification)

    }

    fun gotoHigh(view: View) {
        val notificationManager = NotificationManagerCompat.from(this)
        val notificationChannels = NotificationChannels(this)

        notificationChannels.createNotificationChannels()

        val notification = NotificationCompat.Builder(this,notificationChannels.CHANNEL_1)
            .setSmallIcon(R.drawable.ic_baseline_notifications_active_24)
            .setContentTitle("High priority notification")
            .setContentText("You have new high priority notification")
            .setColor(Color.BLUE)
            .build()

        notificationManager.notify(1, notification)
    }
    fun gotoLow(view: View) {
        val notificationManager = NotificationManagerCompat.from(this)
        val notificationChannels = NotificationChannels(this)

        notificationChannels.createNotificationChannels()

        val notification = NotificationCompat.Builder(this,notificationChannels.CHANNEL_2)
            .setSmallIcon(R.drawable.ic_baseline_notifications_active_24)
            .setContentTitle("Low priority notification")
            .setContentText("You have new low priority notification")
            .setColor(Color.MAGENTA)
            .build()

        notificationManager.notify(2, notification)
    }
}