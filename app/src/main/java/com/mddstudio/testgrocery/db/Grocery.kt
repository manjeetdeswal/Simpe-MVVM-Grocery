package com.mddstudio.testgrocery.db

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "mydb")
data class Grocery (



    var name:String,

    var item:String,

    var prize:String


){
    @PrimaryKey(autoGenerate = true)
    var id:Int? =null
}
