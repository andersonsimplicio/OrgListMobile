package com.anderson.orgs.dao

import com.anderson.orgs.model.Produto

class ProdutosDao {
    companion object {
        private val produtos = mutableListOf<Produto>()
    }
    fun add(produto: Produto){
        produtos.add(produto)
    }
    fun  getLista():List<Produto>{
        return produtos.toList()
    }
}