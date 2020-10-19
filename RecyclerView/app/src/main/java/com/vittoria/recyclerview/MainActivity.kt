package com.vittoria.recyclerview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.*
import androidx.recyclerview.widget.RecyclerView.LayoutManager

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var viewManager = LinearLayoutManager(this)
        var gridLayoutManager = GridLayoutManager(this, 2)
        val recyclerView = findViewById<RecyclerView>(R.id.minhaLista)
        val viewAdapter = MeuAdapter(arrayListOf("Laranja", "Banana", "Maça"))

        recyclerView.apply {
            layoutManager = gridLayoutManager
            adapter = viewAdapter

            addItemDecoration(DividerItemDecoration(context, DividerItemDecoration.VERTICAL))
        }
    }
}