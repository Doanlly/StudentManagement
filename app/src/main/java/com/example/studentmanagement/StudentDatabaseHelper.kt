package com.example.studentmanagement

import android.annotation.SuppressLint
import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import java.lang.Exception

class StudentDatabaseHelper(context: Context): SQLiteOpenHelper(context,DATEBASE_NAME,null,DATABASE_VERSION) {

    companion object{
         private  const val DATABASE_VERSION = 1
        private const val DATEBASE_NAME = "student.db"
        private  const val TBL_STUDENT = "tbl_student"
        private const val ID = "id"
        private  const val NAME = "name"
        private  const val PHONE ="PHONE"

    }
    override fun onCreate(db: SQLiteDatabase?) {
            val createTblStudent = ("CREATE TABLE "+ TBL_STUDENT + "("
                    + ID + " INTEGER PRIMARY KEY, "+ NAME +"TEXT,"
                    + PHONE + " TEXT" + ")")
            db?.execSQL(createTblStudent)
    }

    override fun onUpgrade(db: SQLiteDatabase?, p1: Int, p2: Int) {
        db!!.execSQL("DROP TABLE IF EXISTS $TBL_STUDENT")
        onCreate(db)
    }
    fun insertStudent(stdmd:StudentModel):Long{
        val db = this.writableDatabase

        val contentValue = ContentValues()
        contentValue.put(ID,stdmd.id)
        contentValue.put(NAME,stdmd.name)
        contentValue.put(PHONE,stdmd.phone)

        val sucess = db.insert(TBL_STUDENT,null,contentValue)
        db.close()
        return sucess
    }
    @SuppressLint("Range")
    fun getAllStudent():ArrayList<StudentModel>{
        val stdList:ArrayList<StudentModel> = ArrayList()
        val selectedQuery = "SELECT*FROM $TBL_STUDENT"
        val db = this.readableDatabase

        var cursor:Cursor?

        try{
            cursor = db.rawQuery(selectedQuery,null)

        }catch (e:Exception){
            e.printStackTrace()
            db.execSQL(selectedQuery)
            return ArrayList()
        }

        var id:Int
        var name:String
        var phone:Long
        if(cursor.moveToFirst()){
            do {
                id = cursor.getInt(cursor.getColumnIndex(ID))
                name = cursor.getString(cursor.getColumnIndex("name"))
                phone = cursor.getLong(cursor.getColumnIndex(PHONE))

                var std = StudentModel(id = id, name = name, phone = phone)
                stdList.add(std)
            }while (cursor.moveToNext())
        }
        return stdList
    }
}