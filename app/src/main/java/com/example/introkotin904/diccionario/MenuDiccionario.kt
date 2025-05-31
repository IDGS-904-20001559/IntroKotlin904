package com.example.introkotin904.diccionario

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.introkotin904.R
import com.example.introkotin904.Tem2App.ResultadoActivity

class MenuDiccionario : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_menu_diccionario)

        val btnAgregar = findViewById<Button>(R.id.btnPalabra)
        val btnBuscar = findViewById<Button>(R.id.btnBuscar)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        btnAgregar.setOnClickListener{
            val intent = Intent(this, CapturarPalabra::class.java)
            startActivity(intent)
        }

        btnBuscar.setOnClickListener{
            val intent = Intent(this, BuscarPalabra::class.java)
            startActivity(intent)
        }
    }
}