package com.example.introkotin904.TemaKotlin
import kotlin.math.*

fun main() {
    do{
        print("Ingresa el valor de la a: ")
        val a = readln().toDouble()
        print("Ingresa el valor de la b: ")
        val b = readln().toDouble()
        print("Ingresa el valor de la c: ")
        val c = readln().toDouble()

        val interior = b * b - 4 * a * c

        if (a == 0.0) {
            println("No se permite divir en 0")
        } else if (interior < 0) {
            println("Se encontro raiz negativa")
        } else {
            val x1 = (-b + Math.sqrt(interior)) / (2 * a)
            val x2 = (-b - Math.sqrt(interior)) / (2 * a)

            println("x1 = $x1")
            println("x2 = $x2")
            break
        }
    }while (true)

}
