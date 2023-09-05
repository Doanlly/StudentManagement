package com.example.studentmanagement

import android.content.ClipData.Item
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import com.google.android.material.floatingactionbutton.FloatingActionButton

class DetailStudent : AppCompatActivity() {

    //private  lateinit var textView: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_student)

        //val student = intent.getParcelableExtra<ItemStudentView>("student")
        //val student = intent.getParcelableExtra()//<ItemStudentView?>("student")
        //val student = intent.getParcelableExtra("student", ItemStudentView::class.java)
        val student = intent.getParcelableExtra<ItemStudentView>("student")


        if(student != null){
            val txtName:TextView = findViewById(R.id.txt_namestd)
            val txtphone:TextView  = findViewById(R.id.txt_sdt)
            val age:TextView = findViewById(R.id.txt_agetdetailstd)
            // Sử dụng các thuộc tính của student ở đây
            txtName.text = student.name
            txtphone.text = student.phone.toString()
            age.text = student.age.toString()
        }
        // Lắng nghe sự kiện click trên nút Back
        val backButton: TextView = findViewById(R.id.saveSearchButton)
        backButton.setOnClickListener {
            finish() // Kết thúc activity hiện tại và quay về trang trước đó
        }


    }
}