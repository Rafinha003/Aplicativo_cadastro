package com.example.aplicativodecadastro

import android.view.LayoutInflater
import android.view.ViewGroup
import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView


class Adapter(
    private val myList: List<String>
) : RecyclerView.Adapter<Adapter.MyViewHolder>() {

    class MyViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
       val textName: TextView = itemView.findViewById(R.id.textView)
    }

    //criar cada linha no layout
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
       val itemView = LayoutInflater.from(parent.context).inflate(R.layout.item_adapter, parent, false)
        return MyViewHolder(itemView)
    }

    //retornar o tamanho da lista
    override fun getItemCount() = myList.size

    //método exibir informações
    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
       val name = myList[position]

        holder.textName.text = name
    }
}