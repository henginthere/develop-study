package com.ssafy.gallery

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.util.Log
import java.sql.SQLException

private const val TAG = "PhotoDao_싸피"
class PhotoDao {

    //DB선언부
    lateinit var helper: DBHelper
    lateinit var sqlDB: SQLiteDatabase

    private var mCtx: Context? = null
    private val DB_NAME = "gallery"
    private val TABLE_NAME = "photos"
    private val NUM = "num"
    private val PHOTO_LOCATION = "location"
    private val PHOTO_DATE = "date"
    private val PHOTO_SRC = "src"

    @Throws(SQLException::class)
    fun open() {
        helper = DBHelper(mCtx!!)
        sqlDB = helper.writableDatabase
    }

    fun dbOpenHelper(context: Context) {
        this.mCtx = context
        helper = DBHelper(context)
    }

    fun create() {
        // DB생성
        helper.onCreate(sqlDB)
    }

    fun upgrade(oldVersion: Int, newVersion: Int) {
        //DB version 변경
        helper.onUpgrade(sqlDB, 1, 2)
    }

    fun close() {
        //DB종료
        sqlDB.close()
    }

    //사진 전체 조회
    fun selectAllPhotos(): MutableList<Photo>{
        val columns = arrayOf(NUM, PHOTO_LOCATION, PHOTO_DATE, PHOTO_SRC)
        val cursor = sqlDB.query(TABLE_NAME, columns, null, null, null, null, null)

        var result = mutableListOf<Photo>()

        while(cursor.moveToNext()){
            result.add(Photo(cursor.getInt(0), cursor.getString(1), cursor.getString(2), cursor.getLong(3)))
        }
        return result
    }

    //특정 사진 조회
    fun selectPhotos(num : Int) : Photo?{
        sqlDB.rawQuery("SELECT * FROM $TABLE_NAME WHERE num = $num",null).use{
            return if(it.moveToFirst())
                Photo(it.getInt(0), it.getString(1), it.getString(2), it.getLong(3))
            else
                null
        }
    }

    inner class DBHelper(context: Context) : SQLiteOpenHelper(context, DB_NAME, null, 1) {
        // 테이블 생성
        override fun onCreate(db: SQLiteDatabase?) {
            // 구현

            var query: String = "CREATE TABLE if not exists $TABLE_NAME (num integer primary key autoincrement, location text, date text, src long)"
            db?.execSQL(query)
            Log.d(TAG, "onCreate: DB 생성")
        }

        // 테이블 삭제 후 생성
        override fun onUpgrade(db: SQLiteDatabase?, p1: Int, p2: Int) { //테이블 삭제 후 생성
            var query: String = "DROP TABLE if exists $TABLE_NAME"
            db?.execSQL(query)
            onCreate(db)
        }
    }
}