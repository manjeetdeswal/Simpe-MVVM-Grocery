package com.mddstudio.testgrocery.rapo

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.mddstudio.testgrocery.db.Grocery
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class GroViewModel(private  val groRapo: GroRapo):ViewModel() {

     fun insert(grocery: Grocery) = CoroutineScope(Dispatchers.IO).launch{
         groRapo.insert(grocery)
     }


     fun delete(grocery: Grocery) =CoroutineScope(Dispatchers.IO).launch{
        groRapo.delete(grocery)
    }

    fun getall()=
        groRapo.getAll()

}

class GroFactory(private val groRapo: GroRapo): ViewModelProvider.NewInstanceFactory() {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
       return GroViewModel(groRapo) as T
    }

}