package com.ssafy.broadcast_receiver

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.PowerManager
import android.util.Log
import androidx.annotation.RequiresApi

private const val TAG = "BroadcastActivity_싸피"
class BroadcastActivity : AppCompatActivity() {

    private lateinit var brScreen: BroadcastReceiver
    private lateinit var brBattery: BatteryReceiver

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_broadcast)
        title = "BroadcastActivity"

        // 1. Screen On/Off
        var intentFilterScreen = IntentFilter(Intent.ACTION_SCREEN_OFF)
        intentFilterScreen.addAction(Intent.ACTION_SCREEN_ON)
        brScreen = object: BroadcastReceiver() {
            override fun onReceive(context: Context?, intent: Intent?) {
                val action = intent!!.action
                Log.d(TAG, "onReceive: $action")
                
                when (action) {
                    Intent.ACTION_SCREEN_ON -> {
                        Log.d(TAG, "onReceive: ACTION_SCREEN_ON")
                    }
                    Intent.ACTION_SCREEN_OFF -> {
                        Log.d(TAG, "onReceive: ACTION_SCREEN_OFF")
                    }
                }
            }
        }
        registerReceiver(brScreen, intentFilterScreen)

        // 2. Power On/Off
        val powerManager = getSystemService(Context.POWER_SERVICE) as PowerManager
        if (powerManager.isInteractive) {
            Log.d(TAG, "onCreate: POWER_SERVICE - Power ON")
        }
        else {
            Log.d(TAG, "onCreate: POWER_SERVICE - Power OFF")
        }

        // 3. Battery Low (에뮬레이터에서 battery 수치 15 이하로 조정)
        brBattery = BatteryReceiver()
        val intentFilterBattery = IntentFilter(Intent.ACTION_BATTERY_LOW)
        registerReceiver(brBattery, intentFilterBattery)
    }

    override fun onDestroy() {
        super.onDestroy()

        unregisterReceiver(brScreen)
        unregisterReceiver(brBattery)
    }
}