package com.example.studentmanagement

import android.os.Parcel
import android.os.Parcelable
import kotlin.random.Random

data class ItemStudentView(
    val name: String?,
    val phone: Long,
    val gender:Boolean,
    val age:Int
):Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readString(),
        parcel.readLong(),
        parcel.readByte() != 0.toByte(),
        parcel.readInt()
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(name)
        parcel.writeLong(phone)
        parcel.writeByte(if (gender) 1 else 0)
        parcel.writeInt(age)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<ItemStudentView> {
        override fun createFromParcel(parcel: Parcel): ItemStudentView {
            return ItemStudentView(parcel)
        }

        override fun newArray(size: Int): Array<ItemStudentView?> {
            return arrayOfNulls(size)
        }
    }
}

data class StudentModel(
    var id:Int = getAutoId(),
    val name: String?,
    val phone: Long,
){
    companion object{
        fun getAutoId(): Int {
            var random = Random
        return random.nextInt()
         }}
}


//
//class ItemStudentView
//{
//    private var name:String = ""
//    private var phone:Int= 1
//    private  var gender:Boolean = true
//    private  var age:Int = 0
//
//    constructor(name:String, phone:Int, gender:Boolean,age:Int){
//        this.name = name
//        this.phone = phone
//        this.gender = gender
//        this.age = age
//    }
//
//    constructor()
//
//    var Name:String = ""
//        get()  = field
//        set(value) {
//            field = value
//        }
//    var Phone:Int = 0
//        get()  = field
//        set(value) {
//            field = value
//        }
//    var Gender:Boolean  = true
//        get()  = field
//        set(value) {
//            field = value
//        }
//    var Age:Int = 0
//        get()  = field
//        set(value) {
//            field = value
//        }
//
//
//
//}
