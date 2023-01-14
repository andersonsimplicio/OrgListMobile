package com.anderson.orgs.ui.recycler.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.anderson.orgs.R
import com.anderson.orgs.model.Produto

class ListaProdutosAdapter(
    private val context: Context,
    private val produtos:List<Produto>
) : RecyclerView.Adapter<ListaProdutosAdapter.ListaViewHolder>() {

    class ListaViewHolder(view:View):RecyclerView.ViewHolder(view) {
        fun vincula(produto: Produto) {
               val nome  =  itemView.findViewById<TextView>(R.id.nome)
               val desc  =  itemView.findViewById<TextView>(R.id.descricao)
               val preco  =  itemView.findViewById<TextView>(R.id.preco)
               nome.text = produto.nome
               desc.text = produto.descricao
               preco.text = produto.preco.toString()
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListaViewHolder{
        val inflater:LayoutInflater = LayoutInflater.from(context)
        val view = inflater.inflate(R.layout.produto_item,parent,false)
        return ListaViewHolder(view)
    }

    override fun onBindViewHolder(holder: ListaViewHolder, position: Int) {
        val produto:Produto = produtos[position]
        holder.vincula(produto)
    }

    override fun getItemCount(): Int = produtos.size
}
