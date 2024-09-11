package com.example.aplicativodecadastro

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
        val editTextPassword = findViewById<EditText>(R.id.editTextPassword)
        val buttonLogin = findViewById<Button>(R.id.buttonLogin)
        val buttonRegister = findViewById<Button>(R.id.buttonRegister)

        buttonLogin.setOnClickListener {
            val username = editTextName.text.toString()
            val password = editTextPassword.text.toString()

            if (username == "rafael" && password == "123") {
                Toast.makeText(this, "Bem-vindo, Rafael!", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(this, "Esse usuário não existe. Por favor, crie uma conta.", Toast.LENGTH_SHORT).show()
            }
        }
    }
}
