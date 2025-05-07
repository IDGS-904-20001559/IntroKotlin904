package com.example.introkotin904.TemaKotlin


fun main(){




    /*
    var figuras : mutableFiguras = mutableListOf("cuadrado", "triangulo", "circulo")
    val readOnlyfiguras = listOf("cuadrado", "triangulo", "circulo")
    val mutableFiguras  : list<String> = figuras
    */

    /*
    val frutas = setOf("manzana", "banana", "naranja")
    val frutas = mutableSetOf("manzana", "banana", "naranja")
    */

    /*
    val coches = mapOf("uno" to 1, "dos" to 2, "tres" to 3)
    println(coches)
    val coches2 = mutableMapOf("uno" to 1, "dos" to 2, "tres" to 3)
    println(coches2)
    */


    val readOnlyFiguras = listOf("cuadrado","triangulo","circulo")
    println(readOnlyFiguras)
    println(" la primera figura es ${readOnlyFiguras[0]}")
    println("el primer elemento es ${readOnlyFiguras.first()}")
    println("numero de elementos ${readOnlyFiguras.count()} items")
    println("circulo" in readOnlyFiguras)
    //readOnlyFiguras.add("pentagono")
    var figura : MutableList<String> = mutableListOf("cuadrado2","triangulo2","circulo2")
    figura.add("pentagono2")
    figura.remove("cuadrado2")
}
