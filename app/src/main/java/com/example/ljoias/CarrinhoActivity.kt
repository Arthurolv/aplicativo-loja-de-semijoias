package com.example.myapplication

import ItemCarrinho
import android.os.Bundle
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.ljoias.R

class CarrinhoActivity : AppCompatActivity() {

    private lateinit var carrinhoContainer: LinearLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_carrinho)

        // Inicializando o container onde os itens serão exibidos
        carrinhoContainer = findViewById(R.id.carrinho_container)

        // Receber a lista de itens do carrinho
        val carrinho: ArrayList<ItemCarrinho>? = intent.getParcelableArrayListExtra("carrinho")

        // Adicionar os itens ao layout
        carrinho?.let {
            for (item in it) {
                adicionarItemAoCarrinho(item)
            }
        }
    }

    // Função para adicionar um item ao layout
    private fun adicionarItemAoCarrinho(item: ItemCarrinho) {
        // Criar um LinearLayout para cada item
        val itemLayout = LinearLayout(this).apply {
            orientation = LinearLayout.VERTICAL
            setPadding(8, 8, 8, 8) // Ajuste feito aqui
        }

        // Imagem do item
        val imagem = ImageView(this).apply {
            setImageResource(item.imagemResId)
            layoutParams = LinearLayout.LayoutParams(200, 200)
            contentDescription = "Imagem do ${item.nome}"
        }

        // Descrição do item
        val descricao = TextView(this).apply {
            text = item.nome
            textSize = 18f
            setTextColor(resources.getColor(android.R.color.black))
        }

        // Preço do item
        val preco = TextView(this).apply {
            text = item.preco
            textSize = 18f
            setTextColor(resources.getColor(android.R.color.holo_red_dark))
        }

        // Adiciona os elementos ao layout do item
        itemLayout.addView(imagem)
        itemLayout.addView(descricao)
        itemLayout.addView(preco)

        // Adiciona o layout do item ao container principal
        carrinhoContainer.addView(itemLayout)
    }
}
