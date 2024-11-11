package com.example.myapplication

import ItemCarrinho
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.ImageButton
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.ljoias.AneisActivity
import com.example.ljoias.BrincosActivity
import com.example.ljoias.ColaresActivity
import com.example.ljoias.PulseirasActivity
import com.example.ljoias.R


class MainActivity : AppCompatActivity() {

    // Lista que representa o carrinho de compras
    private val carrinho = arrayListOf<ItemCarrinho>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Definindo os listeners para os botões de favorito
        val favoriteColarButton: ImageButton = findViewById(R.id.favorite_icon_colar)
        favoriteColarButton.setOnClickListener {
            adicionarAoCarrinho("Colar de ouro com inicial em l", "R$ 120,00", R.drawable.colar1)
        }

        val favoritePulseiraButton: ImageButton = findViewById(R.id.favorite_icon_pulseira)
        favoritePulseiraButton.setOnClickListener {
            adicionarAoCarrinho("Pulseira de Ouro", "R$ 80,00", R.drawable.pulseira1)
        }

        val favoriteBrincoButton: ImageButton = findViewById(R.id.favorite_icon_brinco)
        favoriteBrincoButton.setOnClickListener {
            adicionarAoCarrinho("Brinco de ouro", "R$ 50,00", R.drawable.brinco1)
        }

        val favoriteAnelButton: ImageButton = findViewById(R.id.favorite_icon_anel)
        favoriteAnelButton.setOnClickListener {
            adicionarAoCarrinho("Aliança de ouro", "R$ 150,00", R.drawable.anel1)
        }
    }

    // Função para adicionar o item ao carrinho
    private fun adicionarAoCarrinho(nome: String, preco: String, imagemResId: Int) {
        val item = ItemCarrinho(nome, preco, imagemResId)
        carrinho.add(item)

        // Mostra uma mensagem de confirmação
        Toast.makeText(this, "$nome foi adicionado ao carrinho.", Toast.LENGTH_SHORT).show()
    }

    // Função chamada ao clicar no ícone do carrinho
    fun abrirPaginaCarrinho(view: View) {
        val intent = Intent(this, CarrinhoActivity::class.java)
        intent.putParcelableArrayListExtra("carrinho", carrinho)
        startActivity(intent)
    }

    // Função chamada ao clicar no ícone da conta
    fun abrirPaginaConta(view: View) {
        val intent = Intent(this, ContaActivity::class.java)
        startActivity(intent)
    }

    fun abrirPulseirasActivity(view: View?) {
        val intent = Intent(
            this,
            PulseirasActivity::class.java
        )
        startActivity(intent)
    }

    fun abrirBrincosActivity(view: View?) {
        val intent = Intent(this, BrincosActivity::class.java)
        startActivity(intent)
    }

    fun abrirColaresActivity(view: View?) {
        val intent = Intent(this, ColaresActivity::class.java)
        startActivity(intent)
    }

    fun abrirAneisActivity(view: View?) {
        val intent = Intent(this, AneisActivity::class.java)
        startActivity(intent)
    }

}
