package com.example.introkotin904.cinepolis

import android.os.Bundle
import android.widget.EditText
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.introkotin904.R

class Cinepolis : AppCompatActivity() {
    private lateinit var et1 : EditText
    private lateinit var et2 : EditText
    private lateinit var et3 : EditText
    private lateinit var tv1: TextView
    private lateinit var tv2: TextView

    private lateinit var rg: RadioGroup
    private lateinit var rb1: RadioButton
    private lateinit var rb2: RadioButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_cinepolis)

        et1 = findViewById<EditText>(R.id.editTextText)
        et2 = findViewById<EditText>(R.id.editTextText2)
        et3 = findViewById<EditText>(R.id.editTextText3)
        tv1 = findViewById<TextView>(R.id.textView6)
        tv2 = findViewById<TextView>(R.id.alerta)

        rg = findViewById<RadioGroup>(R.id.radioGroup2)
        rb1 = findViewById<RadioButton>(R.id.radioButton6)
        rb2 = findViewById<RadioButton>(R.id.radioButton7)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }

    fun calcular(view: android.view.View){
        var max_boletos = 7
        var valor_boleto = 12.00
        var descuento = 0.0
        var cineco = 0.0

        val comprados = max_boletos * et2.text.toString().toInt()

        if (rg.checkedRadioButtonId == rb1.id) cineco = 0.10

        if (et3.text.toString().toInt() > 5){
            descuento = 0.15
        } else if (et3.text.toString().toInt() in 3..5){
            descuento = 0.10
        }

        var decuento_total = descuento + cineco

        if (et3.text.toString().toInt() > comprados){
            tv2.text = "Solo se pueden comprar $comprados boletos"
        }else{
            var subtotal = et3.text.toString().toInt() * valor_boleto
            val total = subtotal * (1 - decuento_total)
            tv1.text = "$ %.2f".format(total)
            tv2.text = ""
        }

    }
}