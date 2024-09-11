package com.example.poliglota

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import com.example.poliglota.ui.theme.PoliglotaTheme

class Tela2 : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val nome = intent.getStringExtra("nome")
        val numero = intent.getIntExtra("numero", 0)
        val double = intent.getDoubleExtra("double", 0.0)

        enableEdgeToEdge()
        setContent {
            PoliglotaTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Tela2(
                        nome = nome,
                        numero = numero,
                        double = double,
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun Tela2(nome: String?, numero:Int, double: Double, modifier: Modifier = Modifier) {
    Column (
        modifier = modifier
            .fillMaxSize()
            .background(Color(0xFF1C1C1E)),
        verticalArrangement = Arrangement.SpaceBetween,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Text(
            text = "Bem vindos à segunda tela do app! Nome: $nome - Numeros $numero - Double $double",
            modifier = modifier,
            fontSize = 16.sp,
            style = TextStyle(
                color = Color.White
            )
        )

    }

}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun GreetingPreview2() {
    PoliglotaTheme {
        Tela2("Android", 12, 0.0, Modifier.fillMaxSize())
    }
}