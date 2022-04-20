package com.ssafy.cleanstore.stuff

import android.app.Activity
import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.EditText
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import com.ssafy.cleanstore.R
import com.ssafy.cleanstore.databinding.ActivityStuffEditBinding
import com.ssafy.cleanstore.dto.Stuff
import java.text.DateFormat
import java.text.SimpleDateFormat
import java.util.*

private const val TAG = "StuffEditActivity_싸피"

class StuffEditActivity : AppCompatActivity() {

    private lateinit var binding: ActivityStuffEditBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityStuffEditBinding.inflate(layoutInflater)
        setContentView(binding.root)
        Log.d(TAG, "onCreate: ")


        // 캘린더 인스턴스 가져오기
        val calendar = Calendar.getInstance()

        binding.calendarView.setOnDateChangeListener { view, year, month, dayOfMonth ->
            // 캘린더 인스턴스에 CalendarView 에서 선택한 날짜 세팅
            calendar.set(year, month, dayOfMonth)

            // 날짜 표기법 Format
//            val dateFormatter = DateFormat.getDateInstance(DateFormat.MEDIUM)
//            val formattedDate = dateFormatter.format(calendar.time)
            var dateFormatter = SimpleDateFormat("yy/MM/dd", Locale.KOREA)
            dateFormatter.timeZone = TimeZone.getTimeZone("Asia/Seoul")
            val formattedDate = dateFormatter.format(calendar.time)

            // TextView 에 날짜 세팅하기
            binding.itemDate.text = formattedDate

        }


        val initStuff = intent.getSerializableExtra("inputStuff") as Stuff
        val index = intent.getIntExtra("inputId",0)

        binding.itemName.setText(initStuff.itemName)
        binding.itemCnt.setText(initStuff.itemCnt.toString())

        //수정모드일 때 삭제버튼 보인다
        if(initStuff.itemName!!.isNotEmpty()){

            binding.btnDelete.visibility = View.VISIBLE
            binding.itemDate.text = initStuff.regDate
//            try {
//                var parse_date = SimpleDateFormat("yy/MM/dd", Locale.KOREA).parse(initStuff.regDate)
//                var tmpDate = cal.time.time - parse_date.time
//            } catch (e: Exception) {
//                e.printStackTrace()
//            }
            //년, 월, 일 나누기
            var splitdate = initStuff.regDate.split("/")

            calendar.set(Integer.parseInt(splitdate[0])+2000, Integer.parseInt(splitdate[1])-1, Integer.parseInt(splitdate[2]))
            binding.calendarView.date = calendar.time.time
            
        }

        //저장 버튼 눌렀을 때
        binding.btnSave.setOnClickListener {

        try {
            val newName: String = binding.itemName.text.toString().trim()
            val newCnt: Int = binding.itemCnt.text.toString().trim().toInt()
            val newDate: String = binding.itemDate.text.toString().trim()
            binding.layoutCnt.error=null

            Log.d(TAG, "onCreate: 저장버튼 누름")
            if (newName.isEmpty()) {
                Toast.makeText(this, "빈 내용이 있습니다.", Toast.LENGTH_SHORT).show()
            } else {
                val intent = Intent(this, StuffActivity::class.java)
                intent.putExtra("inputStuff", Stuff(newName, newCnt, newDate))
                intent.putExtra("inputId",index)
                println(newName)

                //등록
                if(initStuff.itemName.isEmpty()){
                    intent.putExtra("state",0)
                }
                //수정
                else{
                    intent.putExtra("inputId", index)
                    intent.putExtra("state",1)
                }

                Log.d(TAG, "onCreate: 값 입력완료")

                setResult(Activity.RESULT_OK, intent)

                finish()
            }
        } catch(e: NumberFormatException){
            binding.layoutCnt.error = "숫자만 넣을 수 있습니다."
        }

        }

        binding.btnCancel.setOnClickListener {
            Log.d(TAG, "onCreate: 취소")
            finish()
        }

        binding.btnDelete.setOnClickListener {
            Log.d(TAG, "onCreate: 삭제 버튼 누름")
            val intent = Intent(this, StuffActivity::class.java)
            intent.putExtra("inputStuff", Stuff("", 0, ""))
            intent.putExtra("inputId",index)
            intent.putExtra("state",2)

            setResult(RESULT_OK,intent)

            finish()
        }
    }

}