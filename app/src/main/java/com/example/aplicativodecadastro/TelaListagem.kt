package com.example.aplicativodecadastro

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.aplicativodecadastro.databinding.ActivityTelaListagemBinding

private lateinit var binding: ActivityTelaListagemBinding
private val docesList: MutableList<Compra> = mutableListOf()
private val saudavelList: MutableList<Compra> = mutableListOf()
private val diaADiaList: MutableList<Compra> = mutableListOf()
private val extraList: MutableList<Compra> = mutableListOf()

class TelaListagem : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityTelaListagemBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val buttonAddDoces: Button = findViewById(R.id.addDocesButton)
        val buttonAddSaudavel: Button = findViewById(R.id.addSaudavelButton)
        val buttonAddDiaADia: Button = findViewById(R.id.addDiaDiaButton)
        val buttonAddExtra: Button = findViewById(R.id.addExtraButton)

        val newItemName = intent.getStringExtra("itemName")
        val newQuantidade = intent.getStringExtra("quantidade")
        val newCategoria = intent.getStringExtra("categoria")
        val tipoLista = intent.getStringExtra("lista")

        if (!newItemName.isNullOrEmpty() && !newQuantidade.isNullOrEmpty() && !newCategoria.isNullOrEmpty()) {

            if(tipoLista == "doces"){
                docesList.add(Compra(newItemName, newQuantidade, newCategoria))
            }
            if(tipoLista == "saudavel"){
                saudavelList.add(Compra(newItemName, newQuantidade, newCategoria))
            }

            if(tipoLista == "diaADia"){
                diaADiaList.add(Compra(newItemName, newQuantidade, newCategoria))
            }
            if(tipoLista == "extra"){
                extraList.add(Compra(newItemName, newQuantidade, newCategoria))
            }
        }

        buttonAddDoces.setOnClickListener {
            val intent = Intent(this, Tela_adicionar::class.java)
            intent.putExtra("lista", "doces")
            startActivity(intent)
        }

        buttonAddDiaADia.setOnClickListener {
            val intent = Intent(this, Tela_adicionar::class.java)
            intent.putExtra("lista", "diaADia")
            startActivity(intent)
        }

        buttonAddSaudavel.setOnClickListener {
            val intent = Intent(this, Tela_adicionar::class.java)
            intent.putExtra("lista", "saudavel")
            startActivity(intent)
        }

        buttonAddExtra.setOnClickListener{
            val intent = Intent(this, Tela_adicionar::class.java)
            intent.putExtra("lista", "extra")
            startActivity(intent)
        }

        initRecycleView()
    }

    private fun initRecycleView() {
        binding.recyclerViewDoces.layoutManager = LinearLayoutManager(this)
        binding.recyclerViewDoces.setHasFixedSize(true)
        binding.recyclerViewDoces.adapter = Adapter(docesList)

        binding.recyclerViewDiaDia.layoutManager = LinearLayoutManager(this)
        binding.recyclerViewDiaDia.setHasFixedSize(true)
        binding.recyclerViewDiaDia.adapter = Adapter(diaADiaList)

        binding.recyclerViewSaudavel.layoutManager = LinearLayoutManager(this)
        binding.recyclerViewSaudavel.setHasFixedSize(true)
        binding.recyclerViewSaudavel.adapter = Adapter(saudavelList)

        binding.recyclerViewExtra.layoutManager = LinearLayoutManager(this)
        binding.recyclerViewExtra.setHasFixedSize(true)
        binding.recyclerViewExtra.adapter = Adapter(extraList)
    }
}
