package com.mddstudio.testgrocery.db

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query

@Dao
interface GroDao {
    @Insert
    fun insert(grocery: Grocery)

    @Delete
    fun delete(grocery: Grocery)

    @Query("select * from mydb")
    fun getAll():LiveData<List<Grocery>>

}