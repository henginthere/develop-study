package com.ssafy.memo

import android.content.Context
import android.content.res.TypedArray
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.View
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView

class CustomIntro : LinearLayout {

    private lateinit var iv: ImageView
    private lateinit var message: TextView

    // 커스텀 뷰 구현하기
    constructor(context: Context, attrs: AttributeSet) : super(context, attrs) {
        init()
        getAttrs(attrs)
    }

    private fun init() {
        val inflater = LayoutInflater.from(context)
        val view = inflater.inflate(R.layout.custom_intro, this, false)
        addView(view)
        iv = findViewById(R.id.logo)
        message = findViewById(R.id.tvMessage)
    }

    // attrs.xml 파일로부터 속성 정보 확보 - typedArray
    private fun getAttrs(attrs: AttributeSet) {
        val typedArray = context.obtainStyledAttributes(attrs, R.styleable.CustomIntro)
        setTypedArray(typedArray)
    }

    // 속성값을 view 요소들에 연결
    private fun setTypedArray(typedArray: TypedArray) {
        message.text = typedArray.getText(R.styleable.CustomIntro_message)
        iv.setImageResource(
            typedArray.getResourceId(
                R.styleable.CustomIntro_logoImg,
                R.drawable.ic_launcher_foreground
            )
        )
        typedArray.recycle()
    }

}
