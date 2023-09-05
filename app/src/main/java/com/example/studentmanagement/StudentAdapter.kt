package com.example.studentmanagement

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
//Kotlin đã hỗ trợ khởi tạo thuộc tính trong constructor thông qua cú pháp ngắn gọn. To duoi tạo constructor chấp nhận context và items
class StudentAdapter(private  val items:MutableList<ItemStudentView>): RecyclerView.Adapter<StudentAdapter.StudentViewHolder>() {

    inner  class StudentViewHolder(itemView: View):RecyclerView.ViewHolder(itemView)
     var onItemClick:((ItemStudentView)->Unit)? = null
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StudentViewHolder {
        // Sử dụng 'context' và 'items' ở đây khi cần
        // Ví dụ: val inflater = LayoutInflater.from(context)
        // val currentItem = items[position]
        //chuyen doi xml sang view
        return StudentViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.itemstudent_view,
                parent,false))

    }

    override fun getItemCount(): Int {
        return  items.size
    }

    override fun onBindViewHolder(holder: StudentViewHolder, position: Int) {
        val currentItem = items[position]

        holder.itemView.findViewById<TextView>(R.id.name_std_tt).text = currentItem.name
        holder.itemView.findViewById<TextView>(R.id.contextphone_tt).text = currentItem.phone.toString()
        holder.itemView.setOnClickListener {
            onItemClick?.invoke(    currentItem)
        }
    }
    //onbindViewHolder
    // Sử dụng 'context' và 'items' ở đây khi cần
    // Ví dụ: val currentItem = items[position]
    //        holder.textView.setText(items.get(position).Name)
    //        holder.textViewPhone.setText(items.get(position).Phone)
    //        Log.d("StudentAdapter", "Binding data for position $position")
    //        Log.d("StudentAdapter", "Name: ${items[position].Name}")
    //        Log.d("StudentAdapter", "Phone: ${items[position].Phone}")
    //        holder.textView.text = items[position].Name
    //                holder.textViewPhone.text = items[position].Phone.toString() // Chuyển đổi thành chuỗi vì Phone là kiểu Int
    //        holder.textView.setText(items.get(position).Name)
    //        holder.textViewPhone.setText(items.get(position).Phone.toString())
    //        holder.itemView.apply {
    //            name_std_tt = items[position].name
    //            contextphone_tt.text = items[position].phone.toString()
    //        }
}