package com.example.ladm_u1_practica2_almacenamiento

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.ladm_u1_practica2_almacenamiento.Arreglo.registro1
import com.example.ladm_u1_practica2_almacenamiento.Arreglo.registro2
import com.example.ladm_u1_practica2_almacenamiento.Arreglo.registro3
import com.example.ladm_u1_practica2_almacenamiento.Arreglo.registro4

class CustomAdapter: RecyclerView.Adapter<CustomAdapter.ViewHolder>(){

    var titles = arrayOf("Blanca",
        "No",
        "Merepruebes",
        "Beningno")

    var details = arrayOf("Muchos videos nuevos",
        "Kotlin",
        "Mas videos",
        "Gran cantidad de Videos")

    var detalle = arrayOf("Muchos videos nuevos",
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
        viewholder.itemTitle.text = registro1[i]
        viewholder.itemDetail.text = registro2[i]
        viewholder.itemInvitado.text = registro3[i]
        viewholder.itemTotal.text = registro4[i]
    }

    override fun getItemCount(): Int {
        return registro1.size
    }

    inner class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        var itemInvitado: TextView
        var itemTitle: TextView
        var itemDetail: TextView
        var itemTotal: TextView
        init {
            itemInvitado = itemView.findViewById(R.id.invitado)
            itemTitle = itemView.findViewById(R.id.pelicula)
            itemDetail = itemView.findViewById(R.id.orden)
            itemTotal = itemView.findViewById(R.id.total)
        }
    }


}