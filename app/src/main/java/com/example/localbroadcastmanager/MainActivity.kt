package com.example.localbroadcastmanager

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.localbroadcastmanager.content.LocalBroadcastManager
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val localBroadcastManager=LocalBroadcastManager.getInstance(this)
        localBroadcastManager.registerReceiver(receiver, IntentFilter("filter_string"))

        val intent = Intent("filter_string")
        intent.putExtra("key", "My Data")
        intent.putExtra("key2", "My Data2")

        LocalBroadcastManager.getInstance(this).sendBroadcast(intent)
    }

    var receiver: BroadcastReceiver = object : BroadcastReceiver() {
        override fun onReceive(context: Context?, intent: Intent?) {
            if (intent != null) {
                val str = intent.getStringExtra("key")
                val str2 = intent.getStringExtra("key2")

                 textView.text=str+str2
            }
        }
    }
}