package com.vittoria.comunicacaofragment

import android.content.Context
import android.graphics.Rect
import android.os.Bundle
import android.view.MotionEvent
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.fragment_result.*
import java.util.*


class MainActivity : AppCompatActivity(), IResult {
    var inputFragment = FragmentInputs()
    var resultFragment = FragmentResult()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val manager = supportFragmentManager

        val transaction = manager.beginTransaction()
        transaction.replace(R.id.containerInputs, inputFragment)
        transaction.commit()

        val transaction2 = manager.beginTransaction()
        transaction2.replace(R.id.containerResult, resultFragment)
        transaction2.commit()
    }

    override fun changeResult(name: String, age: Int) {
        super.changeResult(name, age)
        var now = Calendar.getInstance().get(Calendar.YEAR).toInt()
        var currentAge = now - age

        when {
            currentAge < 0 -> {
                resultFragment.labelResult.text = "$name ainda não nasceu"
            }

            currentAge == 0 -> {
                resultFragment.labelResult.text = "$name, você tem menos de 1 ano."

            }

            currentAge == 1 -> {
                resultFragment.labelResult.text = "$name, você tem $currentAge ano."
            }
            else -> {
                resultFragment.labelResult.text = "$name, você tem $currentAge anos."
            }
        }
    }

    override fun dispatchTouchEvent(event: MotionEvent): Boolean {
        if (event.action == MotionEvent.ACTION_DOWN) {
            val v: View? = currentFocus
            if (v is EditText) {
                val outRect = Rect()
                v.getGlobalVisibleRect(outRect)
                if (!outRect.contains(event.rawX.toInt(), event.rawY.toInt())) {
                    v.clearFocus()
                    val imm: InputMethodManager =
                        getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
                    imm.hideSoftInputFromWindow(v.getWindowToken(), 0)
                }
            }
        }
        return super.dispatchTouchEvent(event)
    }
}