package com.example.aplicativodecadastro

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

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

            val intent = Intent(this, TelaListagem::class.java)
            intent.putExtra("itemName", itemName)
            intent. putExtra("quantidade", quantidade)
            intent.putExtra("categoria", categoria)
            intent.putExtra("lista", listaSelecionada)
            startActivity(intent)
        }

    }
}