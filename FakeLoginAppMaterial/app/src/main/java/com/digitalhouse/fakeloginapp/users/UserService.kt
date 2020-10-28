package com.digitalhouse.fakeloginapp.users

import android.widget.EditText
import com.digitalhouse.fakeloginapp.R
import com.digitalhouse.fakeloginapp.exceptions.EmptyFieldException
import java.lang.Exception
import kotlinx.android.synthetic.main.activity_sign_up.*

class UserService {
    companion object {
        private val users = arrayListOf<UserModel>()

        /**
         * Realiza login
         */
        fun logIn(email: String, password: String): UserModel? {
            validateUser("", email, password, false)
            val user = users.find {
                it.email == email.toLowerCase().trim() && it.password == password
            }

            if(user != null){
                return user
            }else{
                throw Exception("Usuário não encontrado, verifique o email e/ou senha!")
            }
        }

        /**
         * Registra um usuário
         */
        @Throws(EmptyFieldException::class)
        fun register(name: String, email: String, password: String) {
            validateUser(name, email, password, true);
            // Verifica se já existe usuário com email cadastrado
            val user = users.find {
                it.email == email.toLowerCase().trim()
            }

            if (user != null) {
                throw Exception("E-mail já cadastrado!")
            }


            users.add(UserModel(name, email.toLowerCase().trim(), password))
        }

        fun validateUser(name: String, email: String, password: String, create: Boolean) {
            var editTextIdErrors = ArrayList<Int>()

            if(name.isEmpty() && create){
               editTextIdErrors.add(R.id.editNameSignUp)
            }
            if(email.isEmpty()){
                editTextIdErrors.add(if (create) R.id.editEmailSignUp else R.id.editEmailLogIn)
            }
            if(password.isEmpty()){
                editTextIdErrors.add(if (create) R.id.editPasswordSignUp else R.id.editPasswordLogIn)
            }

            if(editTextIdErrors.count() > 0){
                throw EmptyFieldException("Campo vazio!", editTextIdErrors)
            }
        }
    }
}