package com.example.aplicativodecadastro

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.aplicativodecadastro.databinding.ActivityTelaListagemBinding

private lateinit var biding: ActivityTelaListagemBinding

class TelaListagem : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
         biding = ActivityTelaListagemBinding.inflate(layoutInflater)
        setContentView(biding.root)

        initRecycleView()
    }

    private fun initRecycleView(){
        biding.recyclerView.layoutManager = LinearLayoutManager(this)
        biding.recyclerView.setHasFixedSize(true)
        biding.recyclerView.adapter = Adapter(getList())
    }

    private fun getList() = listOf(
        "Calleri",
        "Igor vinicius",
        "Arboleda",
        "Alisson",
        "Pablo Maia",
        "Luciano",
        "Welligton Rato",
        "William gomes",
        "Sabino",
        "Calleri",
        "Igor vinicius",
        "Arboleda",
        "Alisson",
        "Pablo Maia",
        "Luciano",
        "Welligton Rato",
        "William gomes",
        "Sabino",
        "Calleri",
        "Igor vinicius",
        "Arboleda",
        "Alisson",
        "Pablo Maia",
        "Luciano",
        "Welligton Rato",
        "William gomes",
        "Sabino"
    )
}
