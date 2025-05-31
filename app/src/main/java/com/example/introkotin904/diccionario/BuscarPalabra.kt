package com.example.introkotin904.diccionario

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.introkotin904.R
import org.w3c.dom.Text
import java.io.FileNotFoundException

class BuscarPalabra : AppCompatActivity() {
    private val fileName = "datos.txt"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_buscar_palabra)

        val btnReturn = findViewById<Button>(R.id.btnRegresar)
        val btnBuscar2 = findViewById<Button>(R.id.btnBuscar2)

        val rdGroup = findViewById<RadioGroup>(R.id.rdGroup)
        val rbEspanol = findViewById<RadioButton>(R.id.rbEspanol)
        val rbIngles = findViewById<RadioButton>(R.id.rbIngles)

        val palabra = findViewById<EditText>(R.id.palabra)
        val message = findViewById<TextView>(R.id.messagePalabra)
        val traducir = findViewById<TextView>(R.id.traducida)

        btnReturn.setOnClickListener{
            val intent = Intent(this, MenuDiccionario::class.java)
            startActivity(intent)
        }

        btnBuscar2.setOnClickListener {
            val texto = palabra.text.toString().trim()
            if (texto.isEmpty()) {
                message.text = "Ingresa una palabra"
                return@setOnClickListener
            }

            var encontrado = "Palabra no encontrada"
            try {
                openFileInput(fileName).bufferedReader().useLines { lineas ->
                    for (linea in lineas) {
                        val partes = linea.split(":")
                        if (partes.size == 2) {
                            val ingles = partes[0].trim()
                            val espanol = partes[1].trim()

                            if (rbEspanol.isChecked && ingles.equals(texto, ignoreCase = true)) {
                                encontrado = "$ingles = $espanol"
                                break
                            } else if (!rbEspanol.isChecked && espanol.equals(texto, ignoreCase = true)) {
                                encontrado = "$espanol = $ingles"
                                break
                            }
                        }
                    }
                }
                message.text = "Palabra Encontrada"
            } catch (e: FileNotFoundException) {
                encontrado = "Archivo no encontrado"
            }

            traducir.text = encontrado
        }



        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }


}