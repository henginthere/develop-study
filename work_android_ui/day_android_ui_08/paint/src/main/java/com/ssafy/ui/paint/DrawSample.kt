package com.ssafy.ui.paint

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.util.AttributeSet
import android.util.Log
import android.view.MotionEvent
import android.view.View

data class Point(
    var x: Float,
    var y: Float,
    var isContinue: Boolean,
    var color: Int)

private const val TAG = "DrawSample_싸피"
class DrawSample : View {
    var pointList = arrayListOf<Point>()
    var mColor: Int = Color.RED

    constructor(context: Context?, attrs: AttributeSet?) : super(context, attrs)

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
        Log.d(TAG, "onDraw: mColor:$mColor")

        val p = Paint()
        p.strokeWidth = 10F
        pointList.forEachIndexed { index, point ->
            if (index > 1) {
                if (point.isContinue) {
                    p.color = pointList[index - 1].color
                    canvas.drawLine(pointList[index - 1].x, pointList[index - 1].y, point.x, point.y, p)
                }
            }
        }
    }

    override fun onTouchEvent(event: MotionEvent?): Boolean {

        when (event?.action) {
            MotionEvent.ACTION_DOWN -> {
                pointList.add(Point(event?.x, event?.y, false, mColor))
            }
            MotionEvent.ACTION_MOVE -> {
                Log.d(TAG, "onTouch: event?.x: ${event?.x}, event?.y: ${event?.y}, mcolor:$mColor")
                pointList.add(Point(event?.x, event?.y, true, mColor))
            }
            MotionEvent.ACTION_UP -> {

            }
        }
        invalidate()
        return true
    }

    fun clear() {
        pointList.clear()
        invalidate()
    }
}