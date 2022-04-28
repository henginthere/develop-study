package com.ssafy.ssafygo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.ssafy.ssafygo.databinding.ActivityMainBinding
import kotlinx.coroutines.*
import java.util.Random
import kotlin.coroutines.CoroutineContext

private const val TAG="MainActivity_싸피"
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private val PROGRESS_CNT = 10
    private val PROGRESS_TICK = 300L

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // 버튼 클릭 시
        binding.btnLoad.setOnClickListener {
            //버튼 비활성
            binding.btnLoad.isEnabled = false
            CoroutineScope(Dispatchers.Main).launch {
                loadStore()
            }
        }
    }

    private suspend fun loadStore(){
        var prog = 0
        var center = 0

        //ProgressBar 0에서 100까지 랜덤하게 진행도 증가
        for(i in PROGRESS_CNT downTo 1){
            if (prog>=100){
                prog=100
                binding.btnLoad.isEnabled=true
                binding.tvProgress.text = prog.toString()
                binding.tvState.text = "불러오기 완료!!"
                return
            }
            delay(PROGRESS_TICK)
            center = (binding.progressBar.max - binding.progressBar.progress) / i
            prog += rand(prog , prog + center)

            binding.tvProgress.text = prog.toString()
            binding.progressBar.progress=prog
        }
    }

    private fun rand(end: Int, start: Int): Int{
        val random = Random()
        var answer=0;
        if(start-end>0){
            answer= random.nextInt(start - end) + end
        }
        return answer
    }

}