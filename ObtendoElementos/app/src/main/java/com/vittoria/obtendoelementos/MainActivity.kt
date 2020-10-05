package com.vittoria.obtendoelementos

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_name.*
import kotlinx.android.synthetic.main.activity_name.btnMostrarResultado
import kotlinx.android.synthetic.main.activity_name.textResultado
import kotlinx.android.synthetic.main.activity_salario.*
import kotlinx.android.synthetic.main.activity_temperature.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        //IMPRIMIR NOME ----------------------------------------------------------------------------
        //setContentView(R.layout.activity_name)

        //btnMostrarResultado.setOnClickListener {
            //val nome = editNome.text.toString()

            //textResultado.text = getString(R.string.resultado_nome, nome)
        //}

        //CONVERTER TEMPERATURA --------------------------------------------------------------------
        //setContentView(R.layout.activity_temperature)

        //btnMostrarResultado.setOnClickListener {
            //val temperatura = editTemperatura.text.toString().toDouble();

            //val resultado = ((temperatura * 9)/5) + 32

            //textResultado.text = resultado.toString()
        //}

        //CONVERTER TEMPERATURA --------------------------------------------------------------------
        setContentView(R.layout.activity_salario)

        btnMostrarResultado.setOnClickListener {
        val horas = editHoras.text.toString().toDouble();
        val valorHora = editValor.text.toString().toDouble();

        val resultado = horas * valorHora

        textResultado.text = getString(R.string.resultado_salario, resultado)
        }
    }


}