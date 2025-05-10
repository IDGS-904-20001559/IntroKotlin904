package com.example.introkotin904.TemaKotlin


fun main(){
    while (true){

        println("----MENU----")
        println("1-Suma")
        println("2-Resta")
        println("3-Multiplicacion")
        println("4-Division")
        println("5-Salir")
        print("Selecciona una opcion: ")

        val input = readln()

        when(input){
            "1" -> {
                print("Ingresa el primer valor: ")
                val num1 = readln().toInt()
                print("Ingresa el segundo valor: ")
                val num2 = readln().toInt()

                val res = num1 + num2
                println("La suma de $num1 + $num2 es igual $res")
            }
            "2" -> {
                print("Ingresa el primer valor: ")
                val num1 = readln().toInt()
                print("Ingresa el segundo valor: ")
                val num2 = readln().toInt()

                val res = num1 - num2
                println("La resta de $num1 - $num2 es igual $res")
            }
            "3" -> {
                print("Ingresa el primer valor: ")
                val num1 = readln().toInt()
                print("Ingresa el segundo valor: ")
                val num2 = readln().toInt()

                val res = num1 * num2
                println("La multiplicacion de $num1 * $num2 es igual $res")
            }
            "4" -> {
                print("Ingresa el primer valor: ")
                val num1 = readln().toInt()
                print("Ingresa el segundo valor: ")
                val num2 = readln().toInt()

                if(num1 <= 0){
                    println("No se puede dividir en 0")
                }else if (num2 <= 0){
                    println("No se puede dividir en 0")
                }else{
                    val res = num1 / num2
                    println("La division de $num1 / $num2 es igual $res")
                }
            }
            "5" -> {
                println("Finalizo el programa")
                break
            }
            else -> ("La opcion no existe")
        }
    }

}

