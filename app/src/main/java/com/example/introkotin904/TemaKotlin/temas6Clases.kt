package com.example.introkotin904.TemaKotlin

class usuario(){
    val materia : String = ""
}

class usuario2(val id:Int, val nombre:String){
    val materia : String = ""
    fun hola(){
        println("Hola")
    }
}

fun main(){
    val alumno = usuario()
    val alumno2 = usuario2(1, "Carlos")

    println(alumno2.id)
    println(alumno2.nombre)
    println(alumno2.hola())
}