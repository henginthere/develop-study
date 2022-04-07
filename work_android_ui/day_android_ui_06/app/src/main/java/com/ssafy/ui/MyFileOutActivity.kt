package com.ssafy.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Environment
import android.util.Log
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import java.io.*
import java.util.*

private const val TAG = "MyFileOutActivity_싸피"
class MyFileOutActivity : AppCompatActivity() {

    private lateinit var tvStatus: TextView
    private lateinit var btnSave: Button
    private lateinit var btnLoad: Button
    private lateinit var btnAssets: Button
    private lateinit var btnExternal: Button

    private lateinit var file: File

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_my_file_out)

        tvStatus = findViewById(R.id.tv_status)
        btnSave = findViewById(R.id.btn_save)
        btnLoad = findViewById(R.id.btn_load)
        btnAssets = findViewById(R.id.btn_assets)
        btnExternal = findViewById(R.id.btn_external)

        file = File(filesDir, "data.txt")

        btnSave.setOnClickListener {
            try {
                BufferedWriter(FileWriter(file, true)).use {
                    it.append("지금 시각은 ${Date()} 입니다.\n")
                }
                tvStatus.text = "저장 완료"
            }
            catch(e: IOException) {
                Log.e(TAG, "saveFile: ", e)
            }
        }

        btnLoad.setOnClickListener {
            Log.d(TAG, "file: ${file.canonicalPath}")
            try {
                BufferedReader(FileReader(file)).useLines {
                    // fold : 초기값을 설정하고 왼쪽부터 오른쪽으로 현재의 계산 값에 순차적용하는 함수
                    var data = it.fold("") { total, nextLine ->
                        Log.d(TAG, "loadFile: 지금까지 불러온 내용: $total / 다음 줄: $nextLine")
                        "$total\n$nextLine"
                    }
                    Log.d(TAG, "loadFile: $data")
                    tvStatus.text = data
                }

            }
            catch(e:IOException) {
                Log.e(TAG, "loadFile: ", e)
            }
        }

        btnAssets.setOnClickListener {
            try {
                BufferedReader(InputStreamReader(assets.open("data.txt"))).useLines {
                    var data = it.fold("") { total, nextLine ->
                        "$total\n$nextLine"
                    }
                    Log.d(TAG, "loadAssetsFile: $data")
                    tvStatus.text = data
                }
            }
            catch (e:IOException) {
                Log.e(TAG, "onCreate: assets 파일 로딩 실패", e)
            }
        }

        btnExternal.setOnClickListener {
            Log.d(TAG, "현재 미디어의 상태 ${Environment.getExternalStorageState()}")
            Log.d(TAG, "외장 메모리 경로: ${getExternalFilesDir(null)}")
            if (Environment.getExternalStorageState() == Environment.MEDIA_MOUNTED) {
                val file = File(getExternalFilesDir(null), "data.txt")
                try {
                    BufferedWriter(FileWriter(file)).use {
                        it.append("외부 저장소에 write 하기")
                    }
                    BufferedReader(FileReader(file)).useLines {
                        val lines = it.fold("") { total, nextLine ->
                            "$total\n$nextLine"
                        }
                        tvStatus.text = lines
                    }
                }
                catch (e: IOException) {
                    Log.e(TAG, "onCreate: 외장 메모리 사용 실패", e)
                }
            }
            else {
                Toast.makeText(
                    this, "이 앱은 외장 메모리를 지원하지 않습니다.", Toast.LENGTH_SHORT
                ).show()
            }
        }
    }
}