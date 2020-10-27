package com.digitalhouse.rickapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.digitalhouse.rickapp.api.Personagem
import com.squareup.picasso.Picasso

class AdapterRick (private val dataSet: List<Personagem>) : RecyclerView.Adapter<AdapterRick.ViewHolder>() {

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view){
        private val nome : TextView = view.findViewById(R.id.txtNome)
        private val status : TextView = view.findViewById(R.id.txtStatus)
        private val especie : TextView = view.findViewById(R.id.txtEspecie)
        private val localizacao : TextView = view.findViewById(R.id.txtLocalizacao)
        private val imagem : ImageView = view.findViewById(R.id.imgPersonagem)

        fun bind(personagem: Personagem){
            nome.text = personagem.nome
            status.text = personagem.status + " - "
            especie.text = personagem.especie
            localizacao.text = personagem.localizacao.nome
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
        holder.bind(dataSet[position])
    }
}