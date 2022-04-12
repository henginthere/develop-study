package com.ssafy.cleanstore.dao

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.util.Log
import com.ssafy.cleanstore.dto.Stuff
import java.sql.SQLException

private const val TAG="StuffDao_싸피"
class StuffDao {
    //DB선언부
    lateinit var helper: DBHelper
    lateinit var sqlDB: SQLiteDatabase

    private var mCtx: Context? = null
    private val DB_NAME = "clean_store"
    private val TABLE_NAME = "Stuff"
    private val STUFF_ID = "_id"
    private val STUFF_NAME = "name"
    private val STUFF_CNT = "count"

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
    // 물품 CRUD 구현

    // 물품 등록
    fun stuffInsert(stuff: Stuff) {
        sqlDB.beginTransaction()
        val query = "INSERT INTO Stuff('name','count') values(\"${stuff.itemName}\",\"${stuff.itemCnt}\")"
        sqlDB.execSQL(query)
        sqlDB.setTransactionSuccessful()
        sqlDB.endTransaction()
    }

    // 특정 물품 조회 method
    fun stuffSelect(stuffId: Int): Map<String, Any> {
        val columns = arrayOf("_id", "name", "count")
        val cursor = sqlDB.query(TABLE_NAME, columns, "_id=?", arrayOf(stuffId.toString()), null, null, null)
        var result = mutableMapOf<String, Any>()
        if (cursor.moveToNext()) {
            result.put("_id", cursor.getInt(0))
            result.put("name", cursor.getString(1))
            result.put("count", cursor.getInt(2))
        }
        return result

    }

    // 물품 조회 method
    fun stuffSelectAll(): MutableList<Stuff> {
        val columns = arrayOf("_id", "name", "count")
        val cursor = sqlDB.query(TABLE_NAME, columns, null,null, null, null, null)
        //리스트
        var result = mutableListOf<Stuff>()

        while (cursor.moveToNext()) {
            result.add(Stuff(cursor.getInt(0),cursor.getString(1), cursor.getInt(2)))
        }
        return result
    }

    // 물품정보 변경
    fun stuffUpdate(stuff: Stuff){
        // ContentValues를 이용한 수정
        val contentValues = ContentValues()
        contentValues.put("_id", stuff.id)
        contentValues.put("name", stuff.itemName)
        contentValues.put("count", stuff.itemCnt)

        sqlDB.beginTransaction()
        val result = sqlDB.update(TABLE_NAME, contentValues, "_id=?", arrayOf(stuff.id.toString()))
        // sql을 이용한 수정
        // val query = "update $TABLE set txt=$content where _id=$id";
        // db.execSQL(query)
        if (result > 0) {
            sqlDB.setTransactionSuccessful()
        }
        sqlDB.endTransaction()
    }

    // 물품 삭제 method
    fun stuffDelete(stuffId: Int){
        Log.d(TAG, "stuffDelete: 삭제???")
        sqlDB.beginTransaction()
        //val result = sqlDB.delete(TABLE_NAME, "_id=?", arrayOf(stuffId.toString()))
        // sql을 이용한 삭제
        val query = "delete from $TABLE_NAME where _id=$stuffId";
        Log.d(TAG, "stuffDelete: $stuffId")
        sqlDB.execSQL(query)
        //if (result > 0) {
            sqlDB.setTransactionSuccessful()
        //}
        sqlDB.endTransaction()
    }

    inner class DBHelper(context: Context) : SQLiteOpenHelper(context, DB_NAME, null, 1) {
        // 테이블 생성
        override fun onCreate(db: SQLiteDatabase?) {
            // 구현

            var query: String = "CREATE TABLE if not exists $TABLE_NAME (_id integer primary key autoincrement, name text, count integer)"
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
