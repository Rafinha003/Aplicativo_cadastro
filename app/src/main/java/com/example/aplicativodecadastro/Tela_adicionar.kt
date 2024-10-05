package com.example.aplicativodecadastro

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity


class Tela_adicionar : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tela_adicionar)

        val itemNameEditText: EditText = findViewById(R.id.editTextItem)
        val quantidadeEditText: EditText = findViewById(R.id.editTextQuantidade)
        val categoriaEditText: EditText = findViewById(R.id.editTextCategoria)
        val buttonCancelar: Button = findViewById(R.id.buttonCancelar)
        val confirmarButton: Button = findViewById(R.id.buttonConfirmar)

        val listaSelecionada = intent.getStringExtra("lista")

        buttonCancelar.setOnClickListener {
            val intent = Intent(this, TelaListagem::class.java)
            startActivity(intent)
        }

        confirmarButton.setOnClickListener {
            val itemName = itemNameEditText.text.toString()
            val quantidade = quantidadeEditText.text.toString()
            val categoria = categoriaEditText.text.toString()

            if(categoria.isNullOrEmpty() || quantidade.isNullOrEmpty() || itemName.isNullOrEmpty()){
                Toast.makeText(this, "Preencha todos os campos", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            val intent = Intent(this, TelaListagem::class.java)
            intent.putExtra("itemName", itemName)
            intent. putExtra("quantidade", quantidade)
            intent.putExtra("categoria", categoria)
            intent.putExtra("lista", listaSelecionada)
            startActivity(intent)
        }

    }
}