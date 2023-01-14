package com.anderson.orgs.ui.activity

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.anderson.orgs.R
import com.anderson.orgs.dao.ProdutosDao
import com.anderson.orgs.model.Produto
import com.anderson.orgs.ui.recycler.adapter.ListaProdutosAdapter
import com.google.android.material.floatingactionbutton.FloatingActionButton
import java.math.BigDecimal


class MainActivity: AppCompatActivity(R.layout.activity_main) {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onResume() {
        super.onResume()
        val dao= ProdutosDao()
        val rec:RecyclerView = findViewById<RecyclerView>(R.id.recyclerview)
        rec.adapter = ListaProdutosAdapter(this, produtos = dao.getLista())
        rec.layoutManager = LinearLayoutManager(this)

        val fab = findViewById<FloatingActionButton>(R.id.fb_btn)
        fab.setOnClickListener{
            val intent:Intent= Intent(this,FormProdutoActivity::class.java)
            startActivity(intent)
        }

    }
}