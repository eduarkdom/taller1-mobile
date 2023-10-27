package com.example.myapplication1

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.evaluacion1.EmpleadoHonorarios

class HonorariosActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PantallaHonorario()
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Preview
@Composable
fun PantallaHonorario() {
    val contexto = LocalContext.current
    var sueldoBruto by remember { mutableStateOf("") }
    var sueldoLiquido by remember { mutableStateOf("") }

    Column(
        modifier = Modifier.fillMaxSize().background(Color.White).padding(all = 32.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Spacer(modifier = Modifier.height(30.dp))
        Text("Calcula Sueldo Líquido de\n trabajador a Honorarios",
            style = TextStyle(fontSize = 21.sp),
            textAlign = TextAlign.Center)
        Spacer(modifier = Modifier.height(30.dp))
        TextField(
        value = sueldoBruto,
        onValueChange = { sueldoBruto = it },
        placeholder = { Text("Ingresa Sueldo Bruto")},
        keyboardOptions = KeyboardOptions(
            keyboardType = KeyboardType.Number
        )

        )
        Spacer(modifier = Modifier.height(20.dp))
        Text("El Sueldo líquido es: $sueldoLiquido")
        Button(
        onClick = {
            sueldoLiquido = EmpleadoHonorarios().calcularLiquido(sueldoBruto).toString()
        },
        modifier = Modifier.padding(
            start = 16.dp,
            end = 16.dp,
            top = 32.dp,
            bottom = 32.dp
        ).size(130.dp, 55.dp)
        )   {
        Text("Calcular",
            style = TextStyle(fontSize = 20.sp),

        )}
        Spacer(modifier = Modifier.height(100.dp))
        Button(
            onClick = {
                val intent = Intent(contexto, MainActivity::class.java)
                contexto.startActivity(intent)
            },
            modifier = Modifier.padding(
                start = 16.dp,
                end = 16.dp,
                top = 16.dp,
                bottom = 32.dp
            ).size(130.dp, 55.dp)
        ) {
            Text("Volver",
            style = TextStyle(fontSize = 20.sp))
        }
    }
}
