package com.example.myapplication

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.ljoias.R

class ContaActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_conta)  // Certifique-se de criar o layout 'activity_conta.xml'

        // Verifique se a mensagem de login efetuado deve ser exibida
        val loginConfirmationMessage: TextView = findViewById(R.id.login_confirmation_message)

        // Aqui estamos verificando se a mensagem deve ser visível
        val isLoginSuccessful = intent.getBooleanExtra("isLoginSuccessful", false)

        if (isLoginSuccessful) {
            loginConfirmationMessage.visibility = View.VISIBLE
        } else {
            loginConfirmationMessage.visibility = View.GONE
        }
    }

    // Função para abrir a página de cadastro
    fun abrirPaginaCadastro(view: View) {
        val intent = Intent(this, CadastroActivity::class.java)  // Aqui está a atividade de cadastro correta
        startActivity(intent)
    }
}
