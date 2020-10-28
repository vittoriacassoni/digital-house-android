package com.digitalhouse.fakeloginapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.Toast
import com.digitalhouse.fakeloginapp.exceptions.EmptyFieldException
import com.digitalhouse.fakeloginapp.users.UserService
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_sign_up.*
import java.lang.Exception

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        signUp()

        login()
    }

    private fun login() {
        btnLogin.setOnClickListener {
            var email = editEmailLogIn.text.toString()
            var password = editPasswordLogIn.text.toString()

            try {
                val logIn = UserService.logIn(email, password)
                var intent = Intent(this, WelcomeActivity::class.java)

                intent.putExtra("userName", logIn?.name)

                startActivity(intent)

                clearLoginEditText()
            } catch (emptyError: EmptyFieldException) {
                for (i in 0 until emptyError.fields.count()) {
                    var input = findViewById<EditText>(emptyError.fields[i])
                    input.error = emptyError.message
                }
            } catch (error: Exception) {
                Toast.makeText(this, error.message, Toast.LENGTH_LONG).show()
            }
        }
    }

    private fun signUp() {
        btnSignUpLogin.setOnClickListener {
            var intent = Intent(this, SignUpActivity::class.java)

            startActivity(intent)

            clearLoginEditText()
        }
    }

    private fun clearLoginEditText() {
        editEmailLogIn.text.clear()
        editEmailLogIn.error = null
        editPasswordLogIn.text.clear()
        editPasswordLogIn.error = null
    }
}