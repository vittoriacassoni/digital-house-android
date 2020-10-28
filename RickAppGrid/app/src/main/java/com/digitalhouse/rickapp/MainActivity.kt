package com.digitalhouse.rickapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.digitalhouse.rickapp.api.IRespostaDaApi
import com.digitalhouse.rickapp.api.Personagem
import com.digitalhouse.rickapp.api.RickApi
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var viewManager = GridLayoutManager(this, 2)
        var recyclerView = findViewById<RecyclerView>(R.id.list)

        RickApi.getData(this, object : IRespostaDaApi {
            override fun obtevePersonagens(personagens: List<Personagem>) {
                var toast: Toast? = null

                var adapterRick = AdapterRick(personagens) {
                    toast?.cancel()

                    var intent = Intent(this@MainActivity, DetalheActivity::class.java)
                    intent.putExtra("IMAGEM", it.imagemUrl)
                    intent.putExtra("NOME", it.nome)
                    intent.putExtra("GENERO", it.genero)
                    intent.putExtra("PLANETA", it.localizacao.nome)

                    startActivity(intent)

                    toast = Toast.makeText(this@MainActivity, it.nome, Toast.LENGTH_LONG)
                    toast?.show()
                }

                recyclerView.apply {
                    setHasFixedSize(true)

                    layoutManager = viewManager
                    adapter = adapterRick

                }
            }
        })
    }
}