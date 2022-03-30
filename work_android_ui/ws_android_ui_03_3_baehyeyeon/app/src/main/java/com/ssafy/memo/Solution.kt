package com.ssafy.memo
class Solution{}
fun main(){

    val dx = arrayOf(-1,1,0,0)
    val dy = arrayOf(0,0,-1,1)
    var answer=0
//    var map = arrayOf(
//        arrayOf(0,0,0,0,0,0,0,0,0),
//        arrayOf(0,0,0,0,0,0,0,0,0),
//        arrayOf(0,0,0,0,0,0,0,0,0),
//        arrayOf(0,0,0,0,0,0,0,0,0),
//        arrayOf(0,0,0,0,0,0,0,0,0),
//        arrayOf(0,0,0,0,0,0,0,0,0),
//        arrayOf(0,0,0,0,0,0,0,0,0),
//        arrayOf(0,0,0,0,0,0,0,0,0),
//        arrayOf(0,0,0,0,0,0,0,0,0))
    var map = arrayOf(
        arrayOf(0,0,0,0,0,0,0,0,0),
        arrayOf(0,0,0,0,0,0,0,0,0),
        arrayOf(0,0,0,0,0,0,0,0,0),
        arrayOf(0,0,0,0,0,0,0,0,0),
        arrayOf(0,0,0,0,0,0,0,0,0),
        arrayOf(0,0,0,0,0,0,0,0,0),
        arrayOf(0,0,0,0,0,0,0,0,0),
        arrayOf(0,0,0,0,0,0,0,0,0),
        arrayOf(0,0,0,0,0,0,0,0,0),
        arrayOf(0,0,0,0,0,0,0,0,0),
        arrayOf(0,0,0,0,0,0,0,0,0))

//    val input = arrayOf(
//        arrayOf(6,2,4),
//        arrayOf(1,5,2),
//        arrayOf(0,0,4),
//        arrayOf(6,6,1),
//        arrayOf(2,4,3)
//    )

    val input = arrayOf(
        arrayOf(0,0,4),
        arrayOf(6,0,1),
        arrayOf(2,4,3),
        arrayOf(4,2,4),
        arrayOf(1,5,2),
        arrayOf(10,8,1)
    )
    //그 위치에 소금쟁이가 있는지 확인, 0이면 있음 1이면 없음
    val already = {x:Int, y: Int->
        if(map[x][y]!=0) 0
        else 1
    }

    //연못 안인지 확인, 0이면 연못안, 1이면 연못밖
    val isIn = {x: Int, y: Int->
        if(x in 0..8 && y in 0..8) 0
        else 1
    }

    //소금쟁이 이동
    fun start(i: Int, j:Int, dir: Int){
        var x = i
        var y = j
        for(i in 3 downTo 1) {
            val nx = x + dx[dir - 1] * i
            val ny = y + dy[dir - 1] * i
            //이전 위치 0
            map[x][y] = 0
            if (isIn(nx, ny) == 1 || already(nx, ny) == 0) {return}
            map[nx][ny] = dir
            x = nx
            y = ny
        }
        answer++
    }


    //map에 소금쟁이 위치 입력
    for(i in 0 until input.size){
        val x = input[i][0]
        val y = input[i][1]
        map[x][y]=input[i][2]
    }

    for(i in 0 until input.size){
        start(input[i][0],input[i][1], input[i][2])
    }

    println(answer)

}