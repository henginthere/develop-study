package com.ssafy.ui

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.util.Log

private const val TAG = "DBHelper_싸피"
private const val TABLE = "mytable"

class DBHelper(
    context: Context?,
    name: String?,
    factory: SQLiteDatabase.CursorFactory?,
    version: Int
) : SQLiteOpenHelper(context, name, factory, version) {

    private lateinit var db: SQLiteDatabase

    override fun onCreate(db: SQLiteDatabase) {
        // 테이블 생성 쿼리
        val query: String =
            "CREATE TABLE if not exists $TABLE ( _id integer primary key autoincrement, txt text);";
        db.execSQL(query)
    }

    // upgrade가 필요한 경우 기존 테이블 drop 후 onCreate로 새롭게 생성
    override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {
        val sql: String = "DROP TABLE if exists $TABLE"
        db.execSQL(sql)
        onCreate(db)
    }

    override fun onOpen(db: SQLiteDatabase?) {
        super.onOpen(db)
        this.db = db!!
        Log.d(TAG, "onOpen: database 준비 완료")
    }

    fun insert(content: String) {
        // ContentValues를 이용한 저장
        val contentValues = ContentValues()
        contentValues.put("txt", content)
        db.beginTransaction()
        val result = db.insert(TABLE, null, contentValues)
        // sql을 이용한 저장
        // val query = "INSERT INTO mytable('txt') values('sql 문장 이용용');";
        // db.execSQL(query)
        if (result > 0) {
            db.setTransactionSuccessful()
        }
        db.endTransaction()
    }

    fun list(): String {
        val columns = arrayOf("_id", "txt")
        //val cursor = db.query(TABLE, columns, null, null, null, null, null)
        val cursor = db.rawQuery("select * from $TABLE", null)
        var result = ""
        while (cursor.moveToNext()) {
            result += "_id: ${cursor.getInt(0)}, txt: ${cursor.getString(1)}\n"
        }
        return result
    }

    fun update(id: String, content: String) {
        // ContentValues를 이용한 수정
        val contentValues = ContentValues()
        contentValues.put("txt", content)
        db.beginTransaction()
        val result = db.update(TABLE, contentValues, "_id=?", arrayOf(id))
        // sql을 이용한 수정
        // val query = "update $TABLE set txt=$content where _id=$id";
        // db.execSQL(query)
        if (result > 0) {
            db.setTransactionSuccessful()
        }
        db.endTransaction()
    }

    fun delete(id: String) {
        db.beginTransaction()
        val result = db.delete(TABLE, "_id=?", arrayOf(id))
        // sql을 이용한 삭제
        //val query = "delete from $TABLE where _id=$id";
        // db.execSQL(query)
        if (result > 0) {
            db.setTransactionSuccessful()
        }
        db.endTransaction()
    }

    fun select(id: String): Map<String, Any> {
        val columns = arrayOf("_id", "txt")
        val cursor = db.query(TABLE, columns, "_id=?", arrayOf(id), null, null, null)
        var result = mutableMapOf<String, Any>()
        if (cursor.moveToNext()) {
            result.put("_id", cursor.getInt(0))
            result.put("txt", cursor.getString(1))
        }
        return result
    }

}
