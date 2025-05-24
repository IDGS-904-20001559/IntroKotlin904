package com.example.introkotin904.palindromo

import android.os.Bundle
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.introkotin904.R

class ResultadoPalindromo : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_resultado_palindromo)

        val original = intent.getStringExtra("original")
        val reversa = intent.getStringExtra("reversa")
        val vocales = intent.getStringExtra("vocales")
        val consonantes = intent.getIntExtra("consonantes", 0)

        findViewById<TextView>(R.id.textViewResultado).text =
            "¡Es un palíndromo!\n\n" +
                    "Cadena original: $original\n" +
                    "Reversa: $reversa\n" +
                    "Vocales: $vocales\n" +
                    "Consonantes: $consonantes"

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}