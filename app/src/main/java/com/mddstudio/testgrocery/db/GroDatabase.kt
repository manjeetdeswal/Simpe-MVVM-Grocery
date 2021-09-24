package com.mddstudio.testgrocery.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [Grocery::class], version = 1)
abstract class GroDatabase:RoomDatabase() {

    abstract fun getgrodao() :GroDao



    companion object{
        private var Instance:GroDatabase?=null

       fun getallGro(context: Context):GroDatabase{
           return Instance?:synchronized(this){
               val  builder= Room.databaseBuilder(context.applicationContext,
                   GroDatabase::class.java,"mydb")
                   .build()
             Instance =builder

               return builder
           }

       }
    }
}