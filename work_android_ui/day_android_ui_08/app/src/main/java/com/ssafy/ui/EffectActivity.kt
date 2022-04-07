package com.ssafy.ui

import android.content.Context
import android.media.RingtoneManager
import android.net.Uri
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.VibrationEffect
import android.os.Vibrator
import android.widget.Button
import android.widget.TextView
import androidx.annotation.RequiresApi

class EffectActivity : AppCompatActivity() {

    @RequiresApi(Build.VERSION_CODES.O)  // VibrationEffect 클래스 때문
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_effect)

        val btn1 = findViewById<Button>(R.id.btn1)
        val btn2 = findViewById<Button>(R.id.btn2)
        val btn3 = findViewById<Button>(R.id.btn3)
        val btn4 = findViewById<Button>(R.id.btn4)
        val btn5 = findViewById<Button>(R.id.btn5)
        val btn6 = findViewById<Button>(R.id.btn6)

        val tv1 = findViewById<TextView>(R.id.tv1)

        // 1. 진동 발생(일회성)
        btn1.setOnClickListener {
            val vibrator = getSystemService(Context.VIBRATOR_SERVICE) as Vibrator

            // deprecated  Build.VERSION_CODES.O
            if (Build.VERSION.SDK_INT >= 26) {
                vibrator.vibrate(VibrationEffect.createOneShot(500, VibrationEffect.DEFAULT_AMPLITUDE))
            }
            else {
                vibrator.vibrate(500)
            }
        }

        // 2. 패턴 진동 발생(일회성)
        btn2.setOnClickListener {
            val vibrator = getSystemService(Context.VIBRATOR_SERVICE) as Vibrator
            val vibratorPattern = longArrayOf(100, 300, 200, 200, 300, 200)
            vibrator.vibrate(vibratorPattern, -1)
        }

        // 3. 진동 발생(일회성) - VibrationEffect
        btn3.setOnClickListener {
            val vibrator = getSystemService(Context.VIBRATOR_SERVICE) as Vibrator
            val effect = VibrationEffect.createOneShot(500, VibrationEffect.DEFAULT_AMPLITUDE) //폰에 설정된 진동 세기를 따라감. 두번째 -1임
            vibrator.vibrate(effect)
        }

        // 4. 패턴 진동 발생(일회성) - VibrationEffect
        btn4.setOnClickListener {
            val vibrator = getSystemService(Context.VIBRATOR_SERVICE) as Vibrator
            val vibratorTiming = longArrayOf(100, 200, 100, 200, 100, 200)
            val effect = VibrationEffect.createWaveform(vibratorTiming, -1)
            vibrator.vibrate(effect)
        }

        val uriRingtone = Uri.parse("android.resource://" + packageName + "/" + R.raw.jazzbyrima)
        val ringtone = RingtoneManager.getRingtone(this, uriRingtone)

        // 5.Ringtone
        btn5.setOnClickListener {
            if (btn5.text == "Ringtone_start") {
                ringtone.play()
                btn5.text = "Ringtone_stop"
            }
            else {
                ringtone.stop()
                btn5.text = "Ringtone_start"
            }
        }

        val uriRingtone2 = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_ALARM)
        val ringtone2 = RingtoneManager.getRingtone(this, uriRingtone2)

        // 6. default_bellsound_start
        btn6.setOnClickListener {
            if(btn6.text == "default_bellsound_start") {
                ringtone2.play()
                btn6.text = "default_bellsound_stop"
            }
            else {
                ringtone2.stop()
                btn6.text = "default_bellsound_start"
            }
        }
    }
}