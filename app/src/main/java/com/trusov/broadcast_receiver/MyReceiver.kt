package com.trusov.broadcast_receiver

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.widget.Toast

class MyReceiver : BroadcastReceiver() {
    override fun onReceive(context: Context?, intent: Intent?) {
        when (intent?.action) {
            Intent.ACTION_AIRPLANE_MODE_CHANGED -> {
                val turnOn = intent.getBooleanExtra("state", false)
                val text = if (turnOn) {
                    "Airplane mode activated"
                } else {
                    "Airplane mode unactivated"
                }
                Toast.makeText(context, text, Toast.LENGTH_SHORT).show()
            }
            Intent.ACTION_SCREEN_OFF -> {
                Toast.makeText(context, "Screen off", Toast.LENGTH_SHORT).show()
            }
        }
    }

}