package com.trusov.broadcast_receiver

import android.content.Intent
import android.content.IntentFilter
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {

    private val receiver = MyReceiver()
    private var counter = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        findViewById<Button>(R.id.button).setOnClickListener {
            val intent = Intent().apply {
                action = MyReceiver.ACTION_SEND_BROADCAST
                putExtra(MyReceiver.EXTRA_TEXT, "Broadcast sent ${counter++}")
            }
            sendBroadcast(intent)
        }
        val intentFilter = IntentFilter().apply {
            addAction(Intent.ACTION_AIRPLANE_MODE_CHANGED)
            addAction(Intent.ACTION_SCREEN_OFF)
            addAction(MyReceiver.ACTION_SEND_BROADCAST)
        }
        registerReceiver(receiver, intentFilter)
    }

    override fun onDestroy() {
        super.onDestroy()
        unregisterReceiver(receiver)
    }
}