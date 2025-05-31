package com.example.introkotin904.diccionario

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.introkotin904.R
import com.example.introkotin904.Tem2App.ResultadoActivity

class CapturarPalabra : AppCompatActivity() {
    private val fileName = "datos.txt"


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_capturar_palabra)

        val btnRegresar = findViewById<Button>(R.id.btnReturn)
        val btnGuardar  = findViewById<Button>(R.id.btnGuardar)

        val espanol = findViewById<EditText>(R.id.etEspanol)
        val ingles = findViewById<EditText>(R.id.etIngles)


        btnRegresar.setOnClickListener{
            val intent = Intent(this, MenuDiccionario::class.java)
            startActivity(intent)
        }


        btnGuardar.setOnClickListener {
            val textoEspanol = espanol.text.toString().trim()
            val textoIngles = ingles.text.toString().trim()

            if (textoEspanol.isNotEmpty() && textoIngles.isNotEmpty()) {
                val linea = "$textoIngles:$textoEspanol\n"
                openFileOutput(fileName, MODE_APPEND).use {
                    it.write(linea.toByteArray())
                }
                Toast.makeText(this, "Palabras guardadas", Toast.LENGTH_SHORT).show()
                espanol.text.clear()
                ingles.text.clear()
            } else {
                Toast.makeText(this, "Llena ambos campos", Toast.LENGTH_SHORT).show()
            }
        }

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}