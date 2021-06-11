package com.proyect.reciclerviewnested1.Adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.TextureView
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.proyect.reciclerviewnested1.Models.Horizontal
import com.proyect.reciclerviewnested1.Models.Vertical
import com.proyect.reciclerviewnested1.R

class MainAdapter(val context: Context,
                  val list_vertical: List<Vertical>) :
    RecyclerView.Adapter<MainAdapter.MainViewHolder>() {


    class MainViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        val txt_category : TextView
        val recicler: RecyclerView

        init {
            recicler = itemView.findViewById(R.id.recy_row)
            txt_category = itemView.findViewById(R.id.txt_category)
        }
        fun bindRow(context: Context, vertical: Vertical){
            txt_category.text = vertical.categoria
            val rowAdapter : CategoryAdapter = CategoryAdapter(context, vertical.horizontal)
            recicler.layoutManager =LinearLayoutManager(context, RecyclerView.HORIZONTAL, false)
            recicler.adapter = rowAdapter
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainViewHolder {
        return MainViewHolder(LayoutInflater.from(context).inflate(R.layout.card_item, parent, false))
    }

    override fun onBindViewHolder(holder: MainViewHolder, position: Int) {
        holder.bindRow(context, list_vertical[position])
//        holder.txt_category.text =list_vertical[position].categoria
//        setRowRecicler(holder.recicler, list_vertical[position].horizontal, position)
    }

    override fun getItemCount(): Int {
        return list_vertical.size
    }

//    private fun setRowRecicler(recyclerView: RecyclerView, horizontal_data : List<Horizontal>, position: Int){
//        val rowAdapter : CategoryAdapter = CategoryAdapter(context, list_vertical[position].horizontal)
//        recyclerView.layoutManager =LinearLayoutManager(context, RecyclerView.HORIZONTAL, false)
//        recyclerView.adapter = rowAdapter
//    }
}