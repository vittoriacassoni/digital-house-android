package com.vittoria.fragments

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.FragmentManager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val fragmentManager = supportFragmentManager

        btnPrimeiroFragmento.setOnClickListener {
            val fragmentTransaction = fragmentManager.beginTransaction()

            fragmentTransaction.add(R.id.contatinerFragment, PrimeiroFragment())
            fragmentTransaction.commit()
        }

        btnSegundoFragmento.setOnClickListener {
            val fragmentTransaction = fragmentManager.beginTransaction()

            fragmentTransaction.add(R.id.contatinerFragment, SegundoFragment())
            fragmentTransaction.commit()
        }
    }
}