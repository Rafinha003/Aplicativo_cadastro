package com.example.aplicativodecadastro

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast



class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val editTextName = findViewById<EditText>(R.id.editTextName)
        val editTextEmail = findViewById<EditText>(R.id.editTextEmail)
        val editTextPassword = findViewById<EditText>(R.id.editTextPassword)
        val buttonLogin = findViewById<Button>(R.id.buttonLogin)
        val buttonRegister = findViewById<Button>(R.id.buttonRegister)

        val usuarioCadastrado = intent.getStringExtra("nomeUsuario")
        val senhaCadastrado = intent.getStringExtra("senhaUsuario")
        val emailCadastrado = intent.getStringExtra("emailUsuario")

        buttonLogin.setOnClickListener {
            val username = editTextName.text.toString()
            val password = editTextPassword.text.toString()
            val email = editTextEmail.text.toString()

            if ( username == usuarioCadastrado && password == senhaCadastrado && email == emailCadastrado) {
                Toast.makeText(this, "Bem-vindo, $usuarioCadastrado!", Toast.LENGTH_SHORT).show()
                val intent = Intent(this, TelaListagem::class.java)
                startActivity(intent)
            } else if(username.isEmpty() || password.isEmpty() || email.isEmpty()) {
                Toast.makeText(this, "Digite todas as informações para login", Toast.LENGTH_SHORT).show()
            } else{
                Toast.makeText(this, "Digite um usuário existe", Toast.LENGTH_SHORT).show()
            }
        }

        buttonRegister.setOnClickListener {
            val intent = Intent(this, TelaCadsatro::class.java)
            startActivity(intent)
        }

    }
}
