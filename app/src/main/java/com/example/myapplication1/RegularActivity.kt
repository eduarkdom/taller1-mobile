package com.example.myapplication1

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.evaluacion1.EmpleadoRegular

class RegularActivity : AppCompatActivity() {
    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_regular)

        val btnVolver = findViewById<Button>(R.id.btnVolver)
        val btnCalcular = findViewById<Button>(R.id.btnCalcular)
        val editTextSueldoBruto = findViewById<EditText>(R.id.etSueldoBruto)
        val textViewResultado = findViewById<TextView>(R.id.tvResultado)

        btnVolver.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }

        btnCalcular.setOnClickListener {
            val sueldoBrutoStr = editTextSueldoBruto.text.toString()
            val empleadoRegular = EmpleadoRegular()
            val sueldoLiquido = empleadoRegular.calcularLiquido(sueldoBrutoStr)
            textViewResultado.text = "El Sueldo líquido es: $sueldoLiquido"
        }
    }
}


