package com.digitalhouse.rickapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.digitalhouse.rickapp.api.Personagem
import com.squareup.picasso.Picasso

class AdapterRick (private val dataSet: List<Personagem>, private val listener: (Personagem) -> Unit) : RecyclerView.Adapter<AdapterRick.ViewHolder>() {

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view){
        private val nome : TextView = view.findViewById(R.id.txtNome)
        private val imagem : ImageView = view.findViewById(R.id.imgPersonagem)

        fun bind(personagem: Personagem){
            nome.text = personagem.nome
            Picasso.get()
                .load(personagem.imagemUrl)
                .into(imagem)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        var view = LayoutInflater.from(parent.context).inflate(R.layout.item_list, parent, false)

        return ViewHolder(view)
    }

    override fun getItemCount() = dataSet.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        var item = dataSet[position];
        holder.bind(item)

        holder.itemView.setOnClickListener { listener(item) }
    }
}