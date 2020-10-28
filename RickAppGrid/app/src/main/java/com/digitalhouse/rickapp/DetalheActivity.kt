package com.digitalhouse.rickapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import com.squareup.picasso.Picasso

class DetalheActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detalhe)

        val imagem = intent.getStringExtra("IMAGEM")
        val nome = intent.getStringExtra("NOME")
        val genero = intent.getStringExtra("GENERO")
        val planeta = intent.getStringExtra("PLANETA")

        findViewById<TextView>(R.id.txtNome).text = nome
        findViewById<TextView>(R.id.txtGenero).text = genero
        findViewById<TextView>(R.id.txtLocalizacao).text = planeta

        Picasso.get()
            .load(imagem)
            .into(findViewById<ImageView>(R.id.imagem))
    }
}