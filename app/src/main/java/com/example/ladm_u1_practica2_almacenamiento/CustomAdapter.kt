package com.example.ladm_u1_practica2_almacenamiento

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class CustomAdapter: RecyclerView.Adapter<CustomAdapter.ViewHolder>(){

    var titles = arrayOf("Codelia",
        "Suscribete",
        "Videos",
        "Youtube")

    var details = arrayOf("Muchos videos nuevos",
        "Kotlin",
        "Mas videos",
        "Gran cantidad de Videos")

    val images = intArrayOf(R.drawable.ic_launcher_foreground,
        R.drawable.ic_launcher_foreground,
        R.drawable.ic_launcher_foreground,
        R.drawable.ic_launcher_foreground
    )

    override fun onCreateViewHolder(viewGroup: ViewGroup, i: Int): ViewHolder {
        val v = LayoutInflater.from(viewGroup.context).inflate(R.layout.card_layout,viewGroup,false)
        return ViewHolder(v)
    }

    override fun onBindViewHolder(viewholder: ViewHolder, i: Int) {
        viewholder.itemTitle.text = titles[i]
        viewholder.itemDetail.text = details[i]
        viewholder.itemImage.setImageResource(images[i])
    }

    inner class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        var itemImage: ImageView
        var itemTitle: TextView
        var itemDetail: TextView

        init {
            itemImage = itemView.findViewById(R.id.item_image)
            itemTitle = itemView.findViewById(R.id.item_title)
            itemDetail = itemView.findViewById(R.id.item_detail)
        }
    }

    override fun getItemCount(): Int {
        return titles.size
    }

}