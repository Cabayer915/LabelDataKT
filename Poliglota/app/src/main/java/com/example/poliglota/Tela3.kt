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
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import com.example.poliglota.ui.theme.PoliglotaTheme

class Tela3 : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        val nota1 = intent.getDoubleExtra("nota1", 0.0)
        val nota2 = intent.getDoubleExtra("nota2", 0.0)

        enableEdgeToEdge()
        setContent {
            PoliglotaTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Tela3(
                        nota1 = nota1,
                        nota2 = nota2,
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun Tela3(nota1 : Double, nota2 : Double, modifier: Modifier = Modifier) {
    val calculo = (nota1 + nota2) / 2
    val resultado = when {
        calculo >= 6 -> "Aprovação"
        calculo >= 5 && calculo < 6 -> "Recuperação"
        else -> "Reprovação"
    }

    Column (
        modifier = modifier
            .fillMaxSize()
            .background(Color(0xFF1C1C1E)),
        verticalArrangement = Arrangement.SpaceBetween,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Text(
            text = stringResource(R.string.msg_calculo, calculo, resultado),
            modifier = modifier,
            fontSize = 16.sp,
            style = TextStyle(
                color = Color.White
            )
        )

    }

}

@Preview(showBackground = true)
@Composable
fun GreetingPreview3() {
    PoliglotaTheme {
        Tela3(0.0, 0.0, Modifier.fillMaxSize())
    }
}