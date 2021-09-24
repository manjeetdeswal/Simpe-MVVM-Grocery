package com.mddstudio.testgrocery

import android.app.Dialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.mddstudio.testgrocery.databinding.ActivityMainBinding
import com.mddstudio.testgrocery.databinding.DialogBinding
import com.mddstudio.testgrocery.db.GroDatabase
import com.mddstudio.testgrocery.db.Grocery
import com.mddstudio.testgrocery.rapo.GroFactory
import com.mddstudio.testgrocery.rapo.GroRapo
import com.mddstudio.testgrocery.rapo.GroViewModel
import kotlinx.coroutines.flow.asFlow
import kotlinx.coroutines.flow.observeOn

class MainActivity : AppCompatActivity(),GroAdapter.gonclick {

    lateinit var binding: ActivityMainBinding
    lateinit var groAdapter: GroAdapter
    lateinit var groViewModel: GroViewModel
    lateinit var list: List<Grocery>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        list= ArrayList<Grocery>()


        groAdapter = GroAdapter(list,this)

        binding.apply {
            myRecyleview.layoutManager = LinearLayoutManager(this@MainActivity)
            myRecyleview.adapter = groAdapter
            val rapo = GroRapo(GroDatabase.getallGro(this@MainActivity))
            val factory = GroFactory(rapo)
            groViewModel =
                ViewModelProvider(this@MainActivity, factory).get(GroViewModel::class.java)
            groViewModel.getall().observe(this@MainActivity, Observer {
                groAdapter.list = it
                groAdapter.notifyDataSetChanged()

            })
            floatingActionButton.setOnClickListener {
opendialog()
            }

        }

    }

    fun opendialog() {
        val dialog = Dialog(this)
        val binding = DialogBinding.inflate(layoutInflater)
        dialog.setContentView(binding.root)

        binding.apply {
            button1.setOnClickListener {
                dialog.cancel()
            }
            button2.setOnClickListener {
                val item= itemname.text.toString()
                val quant=quantity.text.toString()
                val prize=prize.text.toString()
                if (item.isNotEmpty() && quant.isNotEmpty()&&prize.isNotEmpty()){
                    val grocery=Grocery(item,quant,prize)
                    groViewModel.insert(grocery)
                    Toast.makeText(this@MainActivity,"Added",Toast.LENGTH_LONG).show()
                    dialog.dismiss()

                }else{
                    Toast.makeText(this@MainActivity,"Please enter all details",Toast.LENGTH_LONG).show()

                }

            }

            dialog.show()

        }

    }

    override fun onitemclic(grocery: Grocery) {
      groViewModel.delete(grocery)
        groAdapter.notifyDataSetChanged()
        Toast.makeText(this@MainActivity,"Deleted",Toast.LENGTH_LONG).show()

    }
}