package com.ssafy.memo

import android.content.Context
import android.content.res.TypedArray
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.View
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout

class CustomRecyclerView : LinearLayout {

    private lateinit var num: TextView
    private lateinit var title: TextView
    private lateinit var content: TextView
    private lateinit var date: TextView

    // 커스텀 뷰 구현하기
    constructor(context: Context, attrs: AttributeSet) : super(context, attrs) {
        init()
        getAttrs(attrs)
    }

    private fun init() {
        val inflater = LayoutInflater.from(context)
        val view = inflater.inflate(R.layout.custom_item, this, false)
        addView(view)
        num = findViewById(R.id.num)
        title = findViewById(R.id.todo)
        content = findViewById(R.id.detail)
        date = findViewById(R.id.time)
    }
    // attrs.xml 파일로부터 속성 정보 확보 - typedArray
    private fun getAttrs(attrs: AttributeSet) {
        val typedArray = context.obtainStyledAttributes(attrs, R.styleable.CustomRecyclerView)
        setTypedArray(typedArray)
    }

    // 속성값을 view 요소들에 연결
    private fun setTypedArray(typedArray: TypedArray) {
        num.text = typedArray.getText(R.styleable.CustomRecyclerView_Num)
        title.text = typedArray.getText(R.styleable.CustomRecyclerView_memoTitle)
        content.text = typedArray.getText(R.styleable.CustomRecyclerView_memoContent)
        date.text = typedArray.getText(R.styleable.CustomRecyclerView_memoDate)

        typedArray.recycle()
    }

}
