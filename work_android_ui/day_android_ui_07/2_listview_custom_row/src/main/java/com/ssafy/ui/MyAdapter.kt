package com.ssafy.ui

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.TextView

private const val TAG = "MyAdapter_싸피"
class MyAdapter
    (context: Context, val resource: Int, val objects: Array<String>)
    : ArrayAdapter<String>(context, resource, objects) {

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        // 현재 화면에 출력된 리스트뷰 행들 중 하나의 행 객체를 가져옴
        var currentView = convertView

        // 현재 가져온 리스트의 한 행(currentView)에 한 행을 출력하는 View 객체가 없다면,
        // resource(row.xml)를 이용하여 View 객체를 만든다.
        if (currentView == null) {
            val inflater = LayoutInflater.from(parent.context)
            currentView = inflater.inflate(resource, null)
            currentView.id = position  // 재사용 확인을 위해 id 값으로 position 값 부여
            Log.d(TAG, "getView: $position 행의 View 객체 생성 !!")
        }

        // 한 행에 해당하는 View 객체를 가져오고 데이터를 넣어준다.
        val tvName = currentView!!.findViewById(R.id.tv_name) as TextView
        tvName.text = objects[position]
        Log.d(TAG, "getView: $position 행에 ${objects[position]} 데이터 삽입 (${currentView.id})")

        return currentView
    }
}