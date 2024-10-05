package com.example.aplicativodecadastro

import android.content.Intent
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.Button
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.aplicativodecadastro.databinding.ActivityTelaListagemBinding

private lateinit var binding: ActivityTelaListagemBinding
private val docesList: MutableList<Compra> = mutableListOf()
private val saudavelList: MutableList<Compra> = mutableListOf()
private val diaADiaList: MutableList<Compra> = mutableListOf()
private val extraList: MutableList<Compra> = mutableListOf()
private var idCounter = 1

class TelaListagem : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityTelaListagemBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val buttonAddDoces: Button = findViewById(R.id.addDocesButton)
        val buttonAddSaudavel: Button = findViewById(R.id.addSaudavelButton)
        val buttonAddDiaADia: Button = findViewById(R.id.addDiaDiaButton)
        val buttonAddExtra: Button = findViewById(R.id.addExtraButton)
        val buttonDeletarListaDoce: Button = findViewById(R.id.deleteDocesButton)
        val buttonDeletarLIstaSaudavel: Button = findViewById(R.id.deleteSaudavelButton)
        val buttonDeletarListaDiaADia: Button = findViewById(R.id.deleteDiaDiaButton)
        val buttonDeletarListaExtra: Button = findViewById(R.id.deleteExtraButton)

        val newItemName = intent.getStringExtra("itemName")
        val newQuantidade = intent.getStringExtra("quantidade")
        val newCategoria = intent.getStringExtra("categoria")
        val tipoLista = intent.getStringExtra("lista")

        if (!newItemName.isNullOrEmpty() && !newQuantidade.isNullOrEmpty() && !newCategoria.isNullOrEmpty()) {

            if (tipoLista == "doces") {
                docesList.add(Compra(idCounter++, newItemName, newQuantidade, newCategoria))
                docesList.sortBy { it.nome.uppercase() }
            }
            if (tipoLista == "saudavel") {
                saudavelList.add(Compra(idCounter++, newItemName, newQuantidade, newCategoria))
                saudavelList.sortBy { it.nome.uppercase() }
            }

            if (tipoLista == "diaADia") {
                diaADiaList.add(Compra(idCounter++, newItemName, newQuantidade, newCategoria))
                diaADiaList.sortBy { it.nome.uppercase() }
            }
            if (tipoLista == "extra") {
                extraList.add(Compra(idCounter++, newQuantidade, newItemName, newCategoria))
                extraList.sortBy { it.nome.uppercase() }
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

        buttonAddExtra.setOnClickListener {
            val intent = Intent(this, Tela_adicionar::class.java)
            intent.putExtra("lista", "extra")
            startActivity(intent)
        }


        buttonDeletarListaDoce.setOnClickListener {
            docesList.clear()

            binding.recyclerViewDoces.adapter?.notifyDataSetChanged()
        }

        buttonDeletarListaDiaADia.setOnClickListener {
            diaADiaList.clear()

            binding.recyclerViewDiaDia.adapter?.notifyDataSetChanged()
        }

        buttonDeletarLIstaSaudavel.setOnClickListener {
            saudavelList.clear()

            binding.recyclerViewSaudavel.adapter?.notifyDataSetChanged()
        }

        buttonDeletarListaExtra.setOnClickListener {
            extraList.clear()

            binding.recyclerViewExtra.adapter?.notifyDataSetChanged()
        }

        binding.searchEditText.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable?) {
                val query = s.toString()
                if (query.isNotEmpty()) {
                    val foundItem = searchForItem(query)
                    if (foundItem != null) {
                        showItemDialog(foundItem)
                    }
                }
            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}
            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {}
        })

        initRecycleView()
    }

    private fun searchForItem(query: String): Compra? {
        // Combine todas as listas para pesquisa ou limite a uma lista específica
        val combinedList = docesList + saudavelList + diaADiaList + extraList
        return combinedList.find { it.nome.contains(query, ignoreCase = true) }
    }

    private fun showItemDialog(compra: Compra) {
        val dialog = AlertDialog.Builder(this)
            .setTitle("Item Encontrado")
            .setMessage("Nome: ${compra.nome}\nQuantidade: ${compra.quantidade}\nCategoria: ${compra.categoria}")
            .setPositiveButton("OK", null)
            .create()
        dialog.show()
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