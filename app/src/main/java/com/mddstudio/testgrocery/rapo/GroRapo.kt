package com.mddstudio.testgrocery.rapo

import com.mddstudio.testgrocery.db.GroDao
import com.mddstudio.testgrocery.db.GroDatabase
import com.mddstudio.testgrocery.db.Grocery

class GroRapo(private val groDatabase: GroDatabase) {

    suspend fun insert(grocery: Grocery) {
        groDatabase.getgrodao().insert(grocery)

    }

    suspend fun delete(grocery: Grocery) {
        groDatabase.getgrodao().delete(grocery)
    }

    fun getAll() = groDatabase.getgrodao().getAll()

}