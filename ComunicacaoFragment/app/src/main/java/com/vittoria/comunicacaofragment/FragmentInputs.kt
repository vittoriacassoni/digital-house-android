package com.vittoria.comunicacaofragment

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fragment_inputs.*


class FragmentInputs : Fragment() , IResult {

    private lateinit var activity: IResult

    override fun onAttach(context: Context) {
        super.onAttach(context)
        if (context is IResult)
            activity = context
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_inputs, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        btnCalculate.setOnClickListener {
            if (txtName.text?.isEmpty()!!) {
                txtName.error ="Preencha o nome"
            } else if (txtAge.text?.isEmpty()!! || txtAge.text?.toString()?.toInt() ?: 0 <= 1900) {
                txtAge.error = "Preencha o ano"
            } else {
                val name = txtName.text?.toString()
                val age = txtAge.text?.toString()?.toInt()
                activity.changeResult(name!!, age!!)
            }
        }
    }
}