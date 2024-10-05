package com.example.aplicativodecadastro

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Patterns
import android.widget.EditText
import android.widget.Button
import android.widget.Toast

class TelaCadsatro : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tela_cadsatro)

        val nomeusuario = findViewById<EditText>(R.id.CriarNomeUsuario)
        val emailUsuario = findViewById<EditText>(R.id.ColoqueEmail)
        val senhaUsuario = findViewById<EditText>(R.id.CriarSenha)
        val confirmaSenhaUsuario = findViewById<EditText>(R.id.ConfirmaSenha)
        val buttonVoltar = findViewById<Button>(R.id.ButtonVoltar)
        val buttonCadastrar = findViewById<Button>(R.id.ButtonCadastrarConta)

        buttonVoltar.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }

        buttonCadastrar.setOnClickListener {
            val valorNome = nomeusuario.text.toString()
            val valorSenha = senhaUsuario.text.toString()
            val valorEmail = emailUsuario.text.toString()
            val confirmaSenha = confirmaSenhaUsuario.text.toString()

            if(valorSenha != confirmaSenha){
                Toast.makeText(this, "As senhas não dos campos não são iguais", Toast.LENGTH_SHORT).show()
                return@setOnClickListener;
            }

            if(!Patterns.EMAIL_ADDRESS.matcher(valorEmail).matches()){
                Toast.makeText(this, "E-mail inválido", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            if(valorNome.isEmpty() || valorSenha.isEmpty() || valorEmail.isEmpty() || confirmaSenha.isEmpty()){
                Toast.makeText(this, "Existe campos que ainda não foram preenchido", Toast.LENGTH_SHORT).show()
            }else{
                val intent = Intent(this, MainActivity::class.java)
                intent.putExtra("nomeUsuario", valorNome)
                intent.putExtra("senhaUsuario", valorSenha)
                intent.putExtra("emailUsuario", valorEmail)
                startActivity(intent)
                Toast.makeText(this, "Usuário cadastrado com sucesso", Toast.LENGTH_SHORT).show()
            }
        }
    }
}