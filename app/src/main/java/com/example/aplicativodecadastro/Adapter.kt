package com.example.aplicativodecadastro

import android.view.LayoutInflater
import android.view.ViewGroup
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class Adapter(
    private val myList: List<Compra>
) : RecyclerView.Adapter<Adapter.MyViewHolder>() {

    class MyViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        val textName: TextView = itemView.findViewById(R.id.textView)
        val textQuantity: TextView = itemView.findViewById(R.id.textViewQuantidade)
        val textCategoria: TextView = itemView.findViewById(R.id.textViewCategoria)
        val checkButton: Button = itemView.findViewById(R.id.checkButton)
    }

    // criar cada linha no layout
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.item_adapter, parent, false)
        return MyViewHolder(itemView)
    }

    // retornar o tamanho da lista
    override fun getItemCount() = myList.size

    // método para exibir informações
    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val compra = myList[position]


        holder.textName.text = compra.nome
        holder.textQuantity.text = compra.quantidade
        holder.textCategoria.text = compra.categoria

        var isChecked = false
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
    val nome: String,
    val quantidade: String,
    val categoria: String
)

