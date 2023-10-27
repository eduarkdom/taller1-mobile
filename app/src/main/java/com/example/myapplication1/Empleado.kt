package com.example.evaluacion1

abstract class Empleado {

    var sueldoBruto: Double = 0.0

    abstract fun calcularLiquido(sueldoBruto: String): Double
}
