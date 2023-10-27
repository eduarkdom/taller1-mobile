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
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Menu()
        }
    }
}

@Preview
@Composable
fun Menu() {
    val contexto = LocalContext.current
    Column(
        modifier = Modifier.fillMaxSize().background(Color.White).padding(all = 32.dp),        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text("Cálcular Sueldo Líquido",
            style = TextStyle(fontSize = 30.sp)
        )
        Spacer(modifier = Modifier.height(50.dp))
        Button(
            onClick = {
                      val intent = Intent(contexto, HonorariosActivity::class.java)
                contexto.startActivity(intent)
            },
            modifier = Modifier.size(200.dp, 70.dp)
        ) {
            Text(
                "Trabajador a Honorarios",
                style = TextStyle(fontSize = 20.sp),
                textAlign = TextAlign.Center
            )
        }
        Spacer(modifier = Modifier.height(30.dp))
        Button(
            onClick = {
                val intent = Intent(contexto, RegularActivity::class.java)
                contexto.startActivity(intent)
            },
            modifier = Modifier.size(200.dp, 70.dp)
        ) {
            Text(
                "Trabajador a Contrato",
                style = TextStyle(fontSize = 20.sp),
                textAlign = TextAlign.Center
            )
        }
    }
}

