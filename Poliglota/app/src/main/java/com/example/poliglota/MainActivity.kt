package com.example.poliglota

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.poliglota.ui.theme.PoliglotaTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            PoliglotaTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Tela(
                        name = "Android",
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Tela(name: String, modifier: Modifier = Modifier) {
    var nome by remember { mutableStateOf("") }
    var numero by remember { mutableStateOf("") }
    var numeroInvalido by remember { mutableStateOf(false) }
    var double by remember { mutableStateOf("") }
    var doubleInvalido by remember { mutableStateOf(false) }
    var nota1 by remember { mutableStateOf("") }
    var nota2 by remember { mutableStateOf("") }

    val contexto = LocalContext.current

    Column (
        modifier = modifier
            .fillMaxSize()
            .background(Color(0xFF1C1C1E))
            .padding(top = 32.dp)
            .padding(bottom = 32.dp)
            .padding(horizontal = 32.dp)
        ,
        verticalArrangement = Arrangement.SpaceBetween,
        horizontalAlignment = Alignment.CenterHorizontally
    ){

        // Campo de nome
        TextField(
            label = { Text("Nome") },
            value = nome,
            onValueChange = { digitadoNome ->
                nome = digitadoNome
            },
            colors = TextFieldDefaults.textFieldColors(
                unfocusedLabelColor = Color.White,
                cursorColor = Color(0xFFFF3B47),
                focusedLabelColor = Color(0xFFFF3B47),
                focusedTextColor = Color.White,
                unfocusedTextColor = Color.White,
                containerColor = Color.Transparent,
                errorContainerColor = Color.Transparent,
                errorTextColor = Color.White,
                focusedIndicatorColor = Color(0xFFFF3B47)
            ),
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 16.dp)
        )

        // Campo de número (String)
        TextField(
            label = { Text("Numero") },
            value = numero,
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
            onValueChange = { digitadoNumero ->
                numero = digitadoNumero
                numeroInvalido = try {
                    digitadoNumero.toInt() // Tentativa de conversão para Int
                    false
                } catch (e: NumberFormatException) {
                    true
                }
            },
            colors = TextFieldDefaults.textFieldColors(
                unfocusedLabelColor = Color.White,
                cursorColor = Color(0xFFFF3B47),
                focusedLabelColor = Color(0xFFFF3B47),
                focusedTextColor = Color.White,
                unfocusedTextColor = Color.White,
                containerColor = Color.Transparent,
                errorContainerColor = Color.Transparent,
                errorTextColor = Color.White,
                focusedIndicatorColor = Color(0xFFFF3B47)
            ),
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 16.dp)
        )

        // Campo de double (String)
        TextField(
            label = { Text("Double") },
            value = double,
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
            onValueChange = { digitadoDouble ->
                double = digitadoDouble
                doubleInvalido = try {
                    digitadoDouble.toDouble() // Tentativa de conversão para Double
                    false
                } catch (e: NumberFormatException) {
                    true
                }
            },
            colors = TextFieldDefaults.textFieldColors(
                unfocusedLabelColor = Color.White,
                cursorColor = Color(0xFFFF3B47),
                focusedLabelColor = Color(0xFFFF3B47),
                focusedTextColor = Color.White,
                unfocusedTextColor = Color.White,
                containerColor = Color.Transparent,
                errorContainerColor = Color.Transparent,
                errorTextColor = Color.White,
                focusedIndicatorColor = Color(0xFFFF3B47)
            ),
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 16.dp)
        )

        // Campo de nota1 (String)
        TextField(
            value = nota1,
            onValueChange = { nota1 = it },
            label = { Text(stringResource(R.string.nota1)) },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
            colors = TextFieldDefaults.textFieldColors(
                unfocusedLabelColor = Color.White,
                cursorColor = Color(0xFFFF3B47),
                focusedLabelColor = Color(0xFFFF3B47),
                focusedTextColor = Color.White,
                unfocusedTextColor = Color.White,
                containerColor = Color.Transparent,
                errorContainerColor = Color.Transparent,
                errorTextColor = Color.White,
                focusedIndicatorColor = Color(0xFFFF3B47)
            ),
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 16.dp)
        )

        // Campo de nota2 (String)
        TextField(
            value = nota2,
            onValueChange = { nota2 = it },
            label = { Text(stringResource(R.string.nota2)) },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
            colors = TextFieldDefaults.textFieldColors(
                unfocusedLabelColor = Color.White,
                cursorColor = Color(0xFFFF3B47),
                focusedLabelColor = Color(0xFFFF3B47),
                focusedTextColor = Color.White,
                unfocusedTextColor = Color.White,
                containerColor = Color.Transparent,
                errorContainerColor = Color.Transparent,
                errorTextColor = Color.White,
                focusedIndicatorColor = Color(0xFFFF3B47)
            ),
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 16.dp)
        )

        // Converte numero e double para os tipos apropriados antes de enviar
        Button(onClick = {
            val tela2 = Intent(contexto, Tela2::class.java)

            // Converte para Int e Double antes de enviar
            val numeroInt = numero.toIntOrNull() ?: 0
            val doubleDouble = double.toDoubleOrNull() ?: 0.0

            tela2.putExtra("nome", nome)
            tela2.putExtra("numero", numeroInt)
            tela2.putExtra("double", doubleDouble)

            contexto.startActivity(tela2)
        }) {
            Text(text = stringResource(R.string.btn_segundatela))
        }

        Button(onClick = {
            val intent = Intent(contexto, Tela3::class.java)
            intent.putExtra("nota1", nota1.toDoubleOrNull() ?: 0.0)
            intent.putExtra("nota2", nota2.toDoubleOrNull() ?: 0.0)
            contexto.startActivity(intent)
        }) {
            Text(stringResource(R.string.btn_avaliacao))
        }

        // Exibe valores
        Text(text = stringResource(R.string.boa_noite),
            color = Color.White
        )

        // Converte numero e double para os tipos apropriados antes de usar
        val numeroInt = numero.toIntOrNull() ?: 0
        val doubleDouble = double.toDoubleOrNull() ?: 0.0
        Text(text = stringResource(R.string.msg_auxilio, nome, numeroInt, doubleDouble),
            color = Color.White
            )

    }
}

@Preview(showBackground = true, locale = "en")
@Composable
fun GreetingPreview() {
    PoliglotaTheme {
        Tela("Android")
    }
}