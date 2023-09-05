package com.example.studentmanagement

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Parcelable
import android.widget.Toast
import androidx.recyclerview.widget.GridLayoutManager
import  androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val fabAddStudent: FloatingActionButton = findViewById(R.id.floatingac_btn_addstd)
        val items: MutableList<ItemStudentView> = ArrayList()

        val student1 = ItemStudentView("Doan", 846818518, true, 20)
        val student2 = ItemStudentView("Alice", 1234567, false, 22)
        val student3 = ItemStudentView("Bob", 456789, true, 21)
        val student4 = ItemStudentView("Eve", 987654, false, 23)
        val student5 = ItemStudentView("Bob", 456789, true, 21)
        val student6 = ItemStudentView("Eve", 987654, false, 23)


        items.addAll(listOf(student1, student2, student3, student4,student5,student6,ItemStudentView("Eve", 987654, false, 23)))

        var adapter = StudentAdapter(items)

        val recyclerView: RecyclerView = findViewById(R.id.recycle_listStudentView)

        recyclerView.adapter = adapter

        //gridview
        recyclerView.layoutManager = GridLayoutManager(
            this,
            2,
            GridLayoutManager.VERTICAL//dieu huong
            ,false//ko dao  nguoc
        )

        adapter.onItemClick = { clickedStudent ->
            val intent = Intent(this, DetailStudent::class.java)
            intent.putExtra("student", clickedStudent)
            startActivity(intent)
        }
        fabAddStudent.setOnClickListener {
            //Toast.makeText(this,"clicked", Toast.LENGTH_SHORT).show()
            val intent = Intent(this, AddStudentDetailActivity::class.java)

            // Có thể thêm bất kỳ dữ liệu bổ sung nào vào Intent

            // ý định.putExtra("key", value)

            // Bắt đầu hoạt động Chi tiếtStudent
            startActivity(intent)
        }
    }


}
//        recyclerView.adapter = StudentAdapter(items)
//        recyclerView.layoutManager = LinearLayoutManager(
//            this,
//
//            GridLayoutManager.VERTICAL,
//            //LinearLayoutManager.HORIZONTAL,
//            false)
//    }
//        adapter.onItemClick = {
//            val intent = Intent(this,DetailStudent::class.java )
//            intent.putExtra("student", it)
//            startActivity(intent)
//        }
//        adapter.onItemClick = { student ->
//            val intent = Intent(this, DetailStudent::class.java)
//            intent.putExtra("student", student)
//            startActivity(intent)
//        }

//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_main)
//
//        val items: MutableList<ItemStudentView> = ArrayList()
//        val student1 = ItemStudentView("Doan", 846818518 , true,20)
//        val student3 = ItemStudentView("Bob", 456789, true, 21)
//        val student4 = ItemStudentView("Eve", 987654, false, 23)
//        items.addAll(listOf(student1, student3, student4))
//
//        var recyclerView: RecyclerView = findViewById(R.id.recycle_listStudentView)
//        recyclerView.layoutManager = LinearLayoutManager(this)
//        recyclerView.adapter = StudentAdapter(applicationContext, items)
//
//    }