package com.ssafy.memo

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.provider.BaseColumns
import java.sql.SQLException

class MemoDao {

    // DB선언부
    private lateinit var helper: DBHelper
    private lateinit var sqlDB: SQLiteDatabase
    private var mCtx: Context? = null

    private val DATABASE_TABLE = "memos"
    private val NUM = "num"
    private val MEMO_TITLE = "memoTitle"
    private val MEMO_CONTENT = "memoContent"
    private val MEMO_DATE = "memoDate"

    // INSERT
    fun insertMemo(dto: MemoDto) {
        // ContentValues를 이용한 저장
//        val contentValues = ContentValues()
//        contentValues.put("memoTitle", dto.memoTitle)
//        contentValues.put("memoContent", dto.memoContent)
//        contentValues.put("memoDate", dto.memoDate)
        sqlDB.beginTransaction()
//        val result = sqlDB.insert(DATABASE_TABLE, null, contentValues)
         //sql을 이용한 저장
         val query = "INSERT INTO memos('memoTitle','memoContent','memoDate') values(\"${dto.memoTitle}\",\"${dto.memoContent}\",\"${dto.memoDate}\")"
        //
        sqlDB.execSQL(query)
//        if (result > 0) {
            sqlDB.setTransactionSuccessful()
//        }
        sqlDB.endTransaction()
    }

    // UPDATE
    fun updateMemo(dto: MemoDto){
        // ContentValues를 이용한 수정
        val contentValues = ContentValues()
        contentValues.put("memoTitle", dto.memoTitle)
        contentValues.put("memoContent", dto.memoContent)
        contentValues.put("memoDate", dto.memoDate)
        println("수정"+ dto.memoContent)
        sqlDB.beginTransaction()
        val result = sqlDB.update(DATABASE_TABLE, contentValues, "memoTitle=?", arrayOf(dto.memoTitle))
        // sql을 이용한 수정
        // val query = "update $TABLE set txt=$content where _id=$id";
        // db.execSQL(query)
        if (result > 0) {
            sqlDB.setTransactionSuccessful()
        }
        sqlDB.endTransaction()
    }

    // SELECT
    fun selectAllMemos(): MutableList<MemoDto> {
        val columns = arrayOf("memoTitle", "memoContent", "memoDate")
        //val cursor = db.query(TABLE, columns, null, null, null, null, null)
        //val cursor = sqlDB.rawQuery("select * from $DATABASE_TABLE", null)
        val cursor = sqlDB.query(DATABASE_TABLE, columns, null,null, null, null, null)
        //리스트
        println("dddddddddd "+this.getCount())
        var result = mutableListOf<MemoDto>()

        while (cursor.moveToNext()) {
            result.add(MemoDto(cursor.getString(0),cursor.getString(1), cursor.getString(2)))
        }
        return result
    }

//    fun selectMemo(num: Int): MemoDto {
//
//    }
//
    // COUNT
    fun getCount() : Int {
        val columns = arrayOf(MEMO_TITLE,MEMO_CONTENT,MEMO_DATE)
        val cursor = sqlDB.query(DATABASE_TABLE, columns, null, null, null, null, null)
        return cursor.count
    }

    // DELETE
    fun deleteMemo(memoDto: MemoDto){
        sqlDB.beginTransaction()
        val result = sqlDB.delete(DATABASE_TABLE, "memoTitle=?", arrayOf(memoDto.memoTitle))
        // sql을 이용한 삭제
        //val query = "delete from $TABLE where _id=$id";
        // db.execSQL(query)
        if (result > 0) {
            sqlDB.setTransactionSuccessful()
        }
        sqlDB.endTransaction()
    }


    @Throws(SQLException::class)
    fun open() {
        helper = DBHelper(mCtx!!)
        sqlDB = helper.writableDatabase
    }

    fun dbOpenHelper(context: Context) {
        mCtx = context
        helper = DBHelper(context)
    }

    fun create() {
        // DB생성


    }

    fun upgrade(oldVersion: Int, newVersion: Int) {
        // DB version 변경

    }

    fun close() {
        // DB종료

    }

    inner class DBHelper(context: Context) : SQLiteOpenHelper(context,"memos.db", null, 1) {

        private lateinit var db: SQLiteDatabase

        override fun onCreate(db: SQLiteDatabase) { // 테이블 생성

            var query: String = "CREATE TABLE if not exists $DATABASE_TABLE (memoTitle TEXT, memoContent TEXT, memoDate TEXT)"
            db.execSQL(query)

        }

        override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {
            var query: String = "DROP TABLE if exists $DATABASE_TABLE"
            db.execSQL(query)
            onCreate(db)

        }
    }
}