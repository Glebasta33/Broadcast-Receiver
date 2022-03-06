package com.trusov.broadcast_receiver

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.widget.Toast

class MyReceiver : BroadcastReceiver() {
    override fun onReceive(context: Context?, intent: Intent?) {
        when(intent?.action) {
            Intent.ACTION_AIRPLANE_MODE_CHANGED -> {
                val state = intent.getBooleanExtra("state", false)
                val text = if (state) {
                    "Airplane mode"
                } else {
                    "Unactivated"
                }
                Toast.makeText(context, text, Toast.LENGTH_SHORT).show()
            }
            Intent.ACTION_SCREEN_OFF -> {
                Toast.makeText(context, "Screen off", Toast.LENGTH_SHORT).show()
            }
            ACTION_SEND_BROADCAST -> {
                val text = intent.getStringExtra(EXTRA_TEXT)
                Toast.makeText(context, text, Toast.LENGTH_SHORT).show()
            }
        }
    }

    companion object {
        const val ACTION_SEND_BROADCAST = "send_broadcast"
        const val EXTRA_TEXT = "extra"
    }

}