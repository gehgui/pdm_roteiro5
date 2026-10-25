package com.example.pdm_roteiro5

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class ContatoActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_contato)

        val btnTelefone = findViewById<Button>(R.id.btnTelefone)
        val btnEmail = findViewById<Button>(R.id.btnEmail)
        val btnLinkedin = findViewById<Button>(R.id.btnLinkedin)
        val btnPartilhar = findViewById<Button>(R.id.btnPartilhar)

        btnTelefone.setOnClickListener {
            val phoneNumber = "tel:038123456789"
            val intent = Intent(Intent.ACTION_DIAL, Uri.parse(phoneNumber))
            startActivity(intent)
        }

        btnEmail.setOnClickListener {
            val intent = Intent(Intent.ACTION_SENDTO, Uri.parse("mailto:meuemail@estudante.iftm.edu.br"))
            startActivity(intent)
        }

        btnLinkedin.setOnClickListener {
            val url = "https://www.linkedin.com/in/perfil"
            val intent = Intent(Intent.ACTION_VIEW, Uri.parse(url))
            startActivity(intent)
        }

        btnPartilhar.setOnClickListener {
            val shareIntent = Intent().apply {
                action = Intent.ACTION_SEND
                putExtra(
                    Intent.EXTRA_TEXT,
                    "Nome: Seu Nome\nTelefone: (38) 12345-6789\nE-mail: meuemail@estudante.iftm.edu.br\nLinkedIn: linkedin.com/in/perfil"
                )
                type = "text/plain"
            }
            startActivity(Intent.createChooser(shareIntent, "Compartilhar com:"))
        }
    }
}