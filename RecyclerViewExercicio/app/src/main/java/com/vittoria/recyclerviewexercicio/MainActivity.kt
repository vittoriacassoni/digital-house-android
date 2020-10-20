package com.vittoria.recyclerviewexercicio

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.vittoria.recyclerviewexercicio.classes.Adapter
import com.vittoria.recyclerviewexercicio.classes.Chat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var viewManager = LinearLayoutManager(this)
        var recyclerView = findViewById<RecyclerView>(R.id.list)

        var viewAdapter = Adapter(arrayListOf(Chat("Vittoria Cassoni", "Oii tudo bem?", "19:00"),
                                              Chat("Giuliana Cassoni", "Vem jantar", "20:00")))

        recyclerView.apply {
            layoutManager = viewManager
            adapter = viewAdapter

            addItemDecoration(DividerItemDecoration(context, DividerItemDecoration.VERTICAL))
        }


    }
}