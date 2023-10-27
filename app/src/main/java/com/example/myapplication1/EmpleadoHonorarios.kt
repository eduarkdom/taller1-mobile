package com.example.evaluacion1

class EmpleadoHonorarios : Empleado() {
    override fun calcularLiquido(sueldoBruto: String): Double {
        val sueldoBrutoDouble = sueldoBruto.toDoubleOrNull() ?: 0.0
        return sueldoBrutoDouble * 0.87
    }
}
