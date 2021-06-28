package com.proyect.reciclerviewnested1.Adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.proyect.reciclerviewnested1.Models.Horizontal
import com.proyect.reciclerviewnested1.R
import com.squareup.picasso.Picasso

class CategoryAdapter(val context: Context,
                      val list_horizontal: List<Horizontal>)
    : RecyclerView.Adapter<CategoryAdapter.CategoryViewHolder>() {

    class CategoryViewHolder(itemview: View) : RecyclerView.ViewHolder(itemview){
        // Variables del CardView
        var img_poster: ImageView
        var nombre: TextView
        init {
            img_poster =itemview.findViewById(R.id.img_poster)
            nombre = itemview.findViewById(R.id.txt_nombre)
            //Modificadores valores internos
//            img_poster.layoutParams.width = 200
//            img_poster.requestLayout()
//            card.layoutParams.width = 250
//            card.layoutParams.height = 300
//            card.setBackgroundColor(0xFFF50057.toInt())
//            card.requestLayout()
//            card.isFocusable = true
//            card.isFocusableInTouchMode = true
        }

        fun bindCard(horizontal: Horizontal){
            Picasso.get().load(horizontal.image).into(img_poster)
            nombre.setText(horizontal.nombre)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoryViewHolder {
        /* Se le pasa a la actividad el Layout de la tarjeta
        *  inflado hacia el ViewGroup
        * */
        return CategoryViewHolder(LayoutInflater.from(context).inflate(R.layout.card_item, parent, false))
    }

    override fun onBindViewHolder(holder: CategoryViewHolder, position: Int) {
        holder.bindCard(list_horizontal[position])
    }

    override fun getItemCount(): Int {
        return list_horizontal.size
    }
}
