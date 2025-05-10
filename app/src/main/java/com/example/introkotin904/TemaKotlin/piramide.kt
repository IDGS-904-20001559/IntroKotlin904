package com.example.introkotin904.TemaKotlin

fun main() {
    var num: Int
    do {
        print("Ingresa un numero (0 para salir): ")
        num = readln().toInt()

        var fila = 1
        do {
            var col = 1
            do {
                print("*")
                col++
            } while (col <= fila)

            println()
            fila++
        } while (fila <= num)

    } while (num != 0)
}

