package com.example.introkotin904.Tema4

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.material3.AlertDialog
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.introkotin904.R
import java.io.FileNotFoundException

class Ejemplo4Activity : AppCompatActivity() {
    private val fileName = "datos.txt"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_ejemplo5)

        val inputText = findViewById<EditText>(R.id.inputText)
        val outputText = findViewById<TextView>(R.id.outputText)
        val btnBorrar = findViewById<Button>(R.id.btnBorrar)
        val btnGuardar = findViewById<Button>(R.id.saveBtn)
        val btnLeer = findViewById<Button>(R.id.readBtn)

        btnBorrar.setOnClickListener {
            val builder = AlertDialog.Builder(this)
            builder.setTitle("Confirmación")
            builder.setMessage("¿Estas seguro de que deseas borrar los datos?")
            builder.setPositiveButton("Si"){_,_ ->
                try {
                    openFileOutput("datos.txt", MODE_PRIVATE).use {
                        it.write("".toByteArray())
                    }
                    Toast.makeText(this, "Datos Borrados", Toast.LENGTH_LONG).show()
                }catch (e: Exception){
                    e.printStackTrace()
                    Toast.makeText(this, "Error al borrar datos", Toast.LENGTH_LONG).show()
                }
                builder.setNegativeButton("Cancelar"){dialog, _ ->
                    dialog.dismiss()
                }
                val dialog = builder.create()
                dialog.show()
            }
        }

        btnGuardar.setOnClickListener{
            val text = inputText.text.toString()+"\n"
            try {
                openFileOutput(fileName, MODE_APPEND).use {
                    it.write(text.toByteArray())
                }
                println(inputText)
                inputText.text.clear()

            }catch (e: Exception){
                e.printStackTrace()
            }
        }

        btnLeer.setOnClickListener{
            try {
                val contenido = openFileInput(fileName).bufferedReader().useLines { lines ->
                    lines.joinToString { "\n" }
                }
                outputText.text = contenido
            }catch (e: FileNotFoundException){
                outputText.text = "Archivo no Encontrado"
            }catch (e: Exception){
                e.printStackTrace()
            }
        }


        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}