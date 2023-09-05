package com.example.studentmanagement

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.Spinner
import android.widget.Toast


class AddStudentDetailActivity : AppCompatActivity(),
    AdapterView.OnItemSelectedListener {

    private lateinit var edName:EditText
    private  lateinit var edPhone:EditText
    private  lateinit var btnAdd:Button
    private lateinit var btnView:Button
    private lateinit var sqliteHelper:StudentDatabaseHelper

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_student_detail)

        initView()

        val spinnerYear:Spinner = findViewById(R.id.spinneryear)

        val years = mutableListOf<String>()
        for(year in 1990..2015){
            years.add(year.toString())
        }
        val adapter  = ArrayAdapter(this,android.R.layout.simple_spinner_dropdown_item,years)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spinnerYear.adapter = adapter
        spinnerYear.onItemSelectedListener= this

        sqliteHelper = StudentDatabaseHelper(this)
        btnAdd.setOnClickListener { addStudent() }
        btnView.setOnClickListener { getStudent() }

    }

    private fun getStudent() {
        val stdList = sqliteHelper.getAllStudent()
        Log.e("pppp","${stdList.size}")
    }

    private fun addStudent() {
        val name = edName.text.toString()
        val phoneText = edPhone.text.toString() // Convert Editable to String

        if(name.isEmpty()||phoneText.isEmpty()){
            Toast.makeText(this,"Vui lòng nhập trường bắt buộc",Toast.LENGTH_SHORT).show()
        }else{
            val phone = phoneText.toLongOrNull()
            if (phone != null) {
                val sdt = StudentModel(name = name, phone = phone)
                var status = sqliteHelper.insertStudent(sdt)

                //kiem tra viec them thanh cong hay chua
                if (status > -1) {
                    Toast.makeText(this, "Đã thê học sinh", Toast.LENGTH_SHORT).show()
                    clearEditText()
                } else {
                    Toast.makeText(this, "Chưa được lưu", Toast.LENGTH_SHORT).show()

                }
            }else{
                Toast.makeText(this,"Số điện thoại không hợp lệ",Toast.LENGTH_SHORT).show()
            }
        }
    }
//    private fun addStudent() {
//        val name = edName.text.toString()
//        val phoneText = edPhone.text.toString() // Convert Editable to String
//
//        if (name.isEmpty() || phoneText.isEmpty()) {
//            Toast.makeText(this, "Vui lòng nhập trường bắt buộc", Toast.LENGTH_SHORT).show()
//        } else {
//            // Convert phoneText to Long
//            val phone = phoneText.toLongOrNull()
//
//            if (phone != null) {
//                val sdt = StudentModel(name = name, phone = phone)
//                val status = sqliteHelper.insertStudent(sdt)
//
//                // Check if the insertion was successful
//                if (status > -1) {
//                    Toast.makeText(this, "Đã thêm học sinh", Toast.LENGTH_SHORT).show()
//                    clearEditText()
//                } else {
//                    Toast.makeText(this, "Chưa được lưu", Toast.LENGTH_SHORT).show()
//                }
//            } else {
//                // Invalid phone number
//                Toast.makeText(this, "Số điện thoại không hợp lệ", Toast.LENGTH_SHORT).show()
//            }
//        }
//    }


    private fun clearEditText() {
        edName.setText("")
        edPhone.setText("")
        edName.requestFocus()
    }

    private fun initView() {
        edName = findViewById(R.id.edt_name)
        edPhone = findViewById(R.id.enter_phone)
        btnAdd = findViewById(R.id.btn_Add)
        btnView = findViewById(R.id.btnViewHome)

    }

    override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
        //val selectedYear = parent?.getItemAtPosition(position).toString()
        // Xử lý khi người dùng chọn năm sinh

    }

    override fun onNothingSelected(p0: AdapterView<*>?) {
        TODO("Not yet implemented")
        //xu ly khi khong co lua chon nao duoc chon
    }

}