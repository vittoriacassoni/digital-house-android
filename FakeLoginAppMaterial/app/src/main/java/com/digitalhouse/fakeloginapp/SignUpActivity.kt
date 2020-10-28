package com.digitalhouse.fakeloginapp

import android.content.Intent
import android.os.Bundle
import android.widget.CompoundButton
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.digitalhouse.fakeloginapp.exceptions.EmptyFieldException
import com.digitalhouse.fakeloginapp.users.UserService
import kotlinx.android.synthetic.main.activity_sign_up.*
import java.lang.Exception

class SignUpActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)

        checkAgreePolicy.setOnCheckedChangeListener{_, isChecked ->
            btnSignUp.isEnabled = isChecked
        }

        btnLoginSignUp.setOnClickListener {
            finish()
        }

        btnSignUp.setOnClickListener {
            var name = editNameSignUp.text.toString()
            var email = editEmailSignUp.text.toString()
            var password = editPasswordSignUp.text.toString()

            try{
                UserService.register(name, email, password)
                Toast.makeText(this, "Usuário cadastrado com sucesso!", Toast.LENGTH_LONG).show()
                finish()
            }catch (emptyError: EmptyFieldException){
                for(i in 0 until emptyError.fields.count()){
                    var input = findViewById<EditText>(emptyError.fields[i]);
                    input.error = emptyError.message;
                }
            }catch(error: Exception){
                Toast.makeText(this, error.message, Toast.LENGTH_LONG).show()
            }
        }
    }
}