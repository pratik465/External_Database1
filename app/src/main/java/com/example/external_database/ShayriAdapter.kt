package com.example.external_database

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.external_database.databinding.ShayriItemBinding

class ShayariAdapter : RecyclerView.Adapter<ShayariAdapter.ShayariHolder>() {

    lateinit var context: Context

    var shayrilist = ArrayList<ShayriModel>()

    class ShayariHolder(itemView: ShayriItemBinding) : RecyclerView.ViewHolder(itemView.root){
        var binding = itemView
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ShayariHolder {

        context = parent.context
        var binding = ShayriItemBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return ShayariHolder(binding)
    }

    override fun getItemCount(): Int {

        return shayrilist.size
    }

    override fun onBindViewHolder(holder: ShayariHolder, position: Int) {
        holder.binding.apply {
            shayrilist.get(position).apply {

                txtShayri.text = shayrilist.toString()

            }
        }
    }

    fun setshayri(shayarilist: java.util.ArrayList<ShayriModel>) {
        this.shayrilist = shayarilist
    }
}