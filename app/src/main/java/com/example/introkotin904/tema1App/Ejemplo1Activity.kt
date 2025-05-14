package com.example.introkotin904.tema1App

import android.annotation.SuppressLint
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

class Ejemplo1Activity : AppCompatActivity() {
    private lateinit var et1: EditText
    private lateinit var et2: EditText
    private lateinit var tv1: TextView

    private lateinit var rg: RadioGroup
    private lateinit var rb1: RadioButton
    private lateinit var rb2: RadioButton
    private lateinit var rb3: RadioButton
    private lateinit var rb4: RadioButton

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_ejemplo1)

        et1 = findViewById<EditText>(R.id.et1)
        et2 = findViewById<EditText>(R.id.et2)
        tv1 = findViewById<TextView>(R.id.tv1)
        rb1 = findViewById<RadioButton>(R.id.rb1)
        rb2 = findViewById<RadioButton>(R.id.rb2)
        rb3 = findViewById<RadioButton>(R.id.rb3)
        rb4 = findViewById<RadioButton>(R.id.rb4)
        rg = findViewById<RadioGroup>(R.id.radioGroup)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }

    fun calcular(view: android.view.View){
        if (rg.checkedRadioButtonId == rb1.id){
            sumar()
        }else if (rg.checkedRadioButtonId == rb2.id){
            restar()
        }else if (rg.checkedRadioButtonId == rb3.id){
            multiplicar()
        }else if (rg.checkedRadioButtonId == rb4.id){
            dividir()
        }
    }

    fun  sumar(){
        val valor1 = et1.text.toString()
        val valor2 = et2.text.toString()
        val resultado = valor1.toDouble() + valor2.toDouble()
        tv1.text = resultado.toString()
    }

    fun  restar(){
        val valor1 = et1.text.toString()
        val valor2 = et2.text.toString()
        val resultado = valor1.toDouble() - valor2.toDouble()
        tv1.text = resultado.toString()
    }

    fun  multiplicar(){
        val valor1 = et1.text.toString()
        val valor2 = et2.text.toString()
        val resultado = valor1.toDouble() * valor2.toDouble()
        tv1.text = resultado.toString()
    }

    fun  dividir(){
        val valor1 = et1.text.toString()
        val valor2 = et2.text.toString()
        val resultado = valor1.toDouble() / valor2.toDouble()
        tv1.text = resultado.toString()
    }



}

