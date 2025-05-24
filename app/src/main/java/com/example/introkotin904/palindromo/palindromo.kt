package com.example.introkotin904.palindromo

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.introkotin904.R

class palindromo : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_palindromo)

        val buttonCheck = findViewById<Button>(R.id.buttonCheck)
        val editTextInput = findViewById<EditText>(R.id.editTextInput)
        val textViewResult = findViewById<TextView>(R.id.textViewResult)

        buttonCheck.setOnClickListener {
            val input = editTextInput.text.toString()

            if (esPalindromo(input)) {
                val intent = Intent(this, ResultadoPalindromo::class.java).apply {
                    putExtra("original", input)
                    putExtra("reversa", input.reversed())
                    putExtra("vocales", obtenerVocales(input))
                    putExtra("consonantes", contarConsonantes(input))
                }
                startActivity(intent)
            } else {
                textViewResult.text = "La cadena no es un palíndromo."
            }
        }

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }

    fun esPalindromo(cadena: String): Boolean {
        var limpia = ""
        for (caracter in cadena) {
            if (caracter.isLetterOrDigit()) {
                limpia += caracter.lowercaseChar()
            }
        }
        val reversa = limpia.reversed()
        return limpia == reversa
    }

    fun obtenerVocales(cadena: String): String {
        val vocales = "aeiou"
        var resultado = ""
        for (caracter in cadena) {
            if (caracter.lowercaseChar() in vocales) {
                resultado += caracter
            }
        }
        return resultado
    }

    fun contarConsonantes(cadena: String): Int {
        val vocales = "aeiou"
        var contador = 0
        for (caracter in cadena) {
            if (caracter.isLetter()) {
                val letra = caracter.lowercaseChar()
                if (letra !in vocales) {
                    contador++
                }
            }
        }
        return contador
    }


}