package com.example.myapplication

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.ljoias.R

class CadastroActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cadastro) // Certifique-se de que este é o layout correto

        // Referências aos componentes da UI
        val registerButton: Button = findViewById(R.id.register_button)
        val registrationMessage: TextView = findViewById(R.id.registration_confirmation_message)

        // Define a visibilidade inicial da mensagem como "gone"
        registrationMessage.visibility = View.GONE

        // Configura o OnClickListener para o botão de cadastro
        registerButton.setOnClickListener {
            // Torna a mensagem visível
            registrationMessage.visibility = View.VISIBLE
        }
    }
}
