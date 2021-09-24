package com.mddstudio.testgrocery

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.mddstudio.testgrocery.databinding.ItemGrocBinding
import com.mddstudio.testgrocery.db.Grocery

class GroAdapter(var list: List<Grocery>,var groclic: gonclick): RecyclerView.Adapter<GroAdapter.Groholder>() {


    inner class Groholder(binding: ItemGrocBinding):RecyclerView.ViewHolder(binding.root){
        val item=binding.textView4
        val quantiy=binding.textView5
        val prize =binding.textView7
        val delete=binding.imageView

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Groholder {
        val binding=ItemGrocBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return Groholder(binding)
    }

    override fun onBindViewHolder(holder: Groholder, position: Int) {
        val gro =list[position]
        holder.item.setText(""+gro.id+ "  "+gro.name)
        holder.prize.text="Rs:"+gro.prize.toString()
        holder.quantiy.text=gro.item.toString()
        holder.delete.setOnClickListener {
            groclic.onitemclic(gro)
        }

    }

    interface gonclick {
        fun onitemclic(grocery: Grocery)
    }

    override fun getItemCount(): Int {
        return  list.size
    }
}