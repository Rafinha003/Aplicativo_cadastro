package com.example.aplicativodecadastro

import android.view.LayoutInflater
import android.view.ViewGroup
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.recyclerview.widget.RecyclerView

class Adapter(
    private val myList: MutableList<Compra>) : RecyclerView.Adapter<Adapter.MyViewHolder>() {

  private  var isChecked = false

    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val nomeTextView: TextView = itemView.findViewById(R.id.nomeItemTextView)
        val textQuantity: TextView = itemView.findViewById(R.id.QuantidadetextView)
        val textCategoria: TextView = itemView.findViewById(R.id.textViewCategoria)
        val checkButton: Button = itemView.findViewById(R.id.checkButton)
        val editButton: Button = itemView.findViewById(R.id.editarButton)
        val deleteButton: Button = itemView.findViewById(R.id.deletarButton)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.item_adapter, parent, false)
        return MyViewHolder(itemView)
    }

    override fun getItemCount() = myList.size

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val compra = myList[position]

        holder.nomeTextView.text = compra.nome
        holder.textQuantity.text = compra.quantidade
        holder.textCategoria.text = compra.categoria

        holder.deleteButton.setOnClickListener {
            val alertDialog = AlertDialog.Builder(holder.itemView.context)
                .setTitle("Excluir Item")
                .setMessage("Você deseja excluir este item?")
                .setPositiveButton("Excluir") { dialog, which ->
                    myList.removeAt(position)
                    notifyItemRemoved(position)
                    notifyItemRangeChanged(position, myList.size)
                }
                .setNegativeButton("Cancelar", null)
                .create()
            alertDialog.show()
        }

        holder.editButton.setOnClickListener {
            val context = holder.itemView.context

            val dialogView = LayoutInflater.from(context).inflate(R.layout.activity_editar_itens, null)
            val editTextName: EditText = dialogView.findViewById(R.id.editTextName)
            val editTextQuantidade: EditText = dialogView.findViewById(R.id.editTextQuantidade)
            val editTextCategoria: EditText = dialogView.findViewById(R.id.editTextCategoria)

            editTextName.setText(compra.nome)
            editTextQuantidade.setText(compra.quantidade)
            editTextCategoria.setText(compra.categoria)

            val alertDialog = AlertDialog.Builder(context)
                .setTitle("Editar Item")
                .setView(dialogView)
                .setPositiveButton("Salvar") { dialog, which ->
                    val updatedName = editTextName.text.toString()
                    val updatedQuantidade = editTextQuantidade.text.toString()
                    val updatedCategoria = editTextCategoria.text.toString()

                    myList[position] = Compra(compra.id, updatedName, updatedQuantidade, updatedCategoria)

                    notifyItemChanged(position)

                    Toast.makeText(context, "Item atualizado com sucesso!", Toast.LENGTH_SHORT).show()
                }
                .setNegativeButton("Cancelar", null)
                .create()

            alertDialog.show()
        }

        holder.checkButton.setBackgroundResource(R.drawable.baseline_check_box_outline_blank_24)
        holder.checkButton.setOnClickListener {
            isChecked = !isChecked
            if (isChecked) {
                holder.checkButton.setBackgroundResource(R.drawable.baseline_check_box_24)
            } else {
                holder.checkButton.setBackgroundResource(R.drawable.baseline_check_box_outline_blank_24)
            }
        }
    }
}

data class Compra(
    var id: Int,
    var nome: String,
    var quantidade: String,
    var categoria: String
)

