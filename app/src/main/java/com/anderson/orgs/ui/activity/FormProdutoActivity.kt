package com.anderson.orgs.ui.activity

import android.graphics.drawable.Drawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import com.anderson.orgs.R
import com.anderson.orgs.dao.ProdutosDao
import com.anderson.orgs.model.Produto
import java.math.BigDecimal
import java.text.DecimalFormat

class FormProdutoActivity : AppCompatActivity(R.layout.activity_form_produto) {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val botaoSalvar:Button = findViewById<Button>(R.id.salvar)

        botaoSalvar.setOnClickListener{
                val campoNome:EditText = findViewById<EditText>(R.id.nome)
                val campoDescricao:EditText = findViewById<EditText>(R.id.descricao)
                val campoPreco:EditText = findViewById<EditText>(R.id.preco)

                val nome:String = campoNome.text.toString()
                val descricao:String = campoDescricao.text.toString()
                val preco:String = campoPreco.text.toString()
                val valor:BigDecimal =if(preco.isBlank()){
                      BigDecimal.ZERO
                }else{
                    BigDecimal(preco)
                }
                val produto = Produto(
                    nome=nome,
                    descricao=descricao,
                    preco=valor
                )

                val dao =  ProdutosDao()
                dao.add(produto)
                finish()
//                Log.i("ProdutoList","OnCreate: ${dao.getLista()}")
//                Log.i("Produto","OnCreateLits: ${produto.toString()}")
            }



    }

}


