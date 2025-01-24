package com.salvatoreacademy.sa_android_nativo_iniciante_app1

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.cardview.widget.CardView
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class   MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // Buscar elemento pelo id e armanezar em variável (val ou var) - val: não muda - var: pode mudar
        val cvCreature = findViewById<CardView>(R.id.cvCreature)

        // Criar um listener de click para um elemento
        cvCreature.setOnClickListener {
            // Comportamento que sera executado ao clicar no elemento
            Toast.makeText(this, "CardView clicado!", Toast.LENGTH_SHORT).show()

            // Abrir uma nova Activity
            // Criamos uma Intent
            val newActivityIntent = Intent(this, CreatureViewActivity::class.java)

            // Registarmos a Intent com o resultado esperado (abrir uma Activity)
            startActivity(newActivityIntent)
        }
    }
}