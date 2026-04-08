package com.example.logcatbutton

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Surface
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
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.logcatbutton.ui.theme.DebugButtonColors
import com.example.logcatbutton.ui.theme.ErrorButtonColors
import com.example.logcatbutton.ui.theme.InfoButtonColors
import com.example.logcatbutton.ui.theme.LogcatButtonTheme
import com.example.logcatbutton.ui.theme.WarningButtonColors

const val TAG = "TesteAndroid"

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LogcatButtonTheme {
                App()
            }
        }
    }
}

@Composable
private fun App() {
    var nome by remember { mutableStateOf("") }
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colorScheme.background
    ) {
        Column(
            verticalArrangement = Arrangement.SpaceEvenly,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            val image = painterResource(R.drawable.corinthians)
            Image(
                painter = image,
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .width(70.dp)
                    .height(70.dp)
            )

            Greeting("PAM 2")

            Row(
                Modifier.fillMaxWidth(),
                Arrangement.Center
            ) {
                TextField(
                    value = nome,
                    onValueChange = { novoValor -> nome = novoValor },
                    label = { Text("Digite seu nome:") },
                )
            }

            ActionButton(
                text = "Mundial de Clubes",
                buttonColors = ErrorButtonColors(),
                modifier = Modifier.fillMaxWidth(0.6f)
            ) {
                Log.e(TAG, "O Mundo é Preto e Branco: Olá, $nome. O Corinthians é bicampeão mundial")
            }

            ActionButton(
                text = "Libertadores",
                buttonColors = WarningButtonColors(),
                modifier = Modifier.fillMaxWidth(0.6f)
            ) {
                Log.w(TAG, "Donos da América: Olá, $nome. O Corinthians é campeão da libertadores")
            }

            ActionButton(
                text = "Brasileirão",
                buttonColors = DebugButtonColors(),
                modifier = Modifier.fillMaxWidth(0.6f)
            ) {
                Log.d(TAG, "O Terror do Brasil: Olá, $nome. O Corinthians é heptacampeão brasileiro")
            }

            ActionButton(
                text = "Copa do Brasil",
                buttonColors = InfoButtonColors(),
                modifier = Modifier.fillMaxWidth(0.6f)
            ) {
                Log.i(TAG, "Rei de Copas: Olá, $nome. O Corinthians é tetracampeão da copa do brasil")
            }
        }
    }
}

@Composable
fun ActionButton(
    text: String,
    buttonColors: ButtonColors = ButtonDefaults.buttonColors(),
    modifier: Modifier = Modifier,
    block: () -> Unit
) {
    // Trocamos para OutlinedButton para suportar a borda branca facilmente
    OutlinedButton(
        onClick = block,
        shape = RoundedCornerShape(5.dp),
        colors = buttonColors,
        border = BorderStroke(1.dp, Color.White), // Borda branca de 1dp
        modifier = modifier
    ) {
        Text(text = text)
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "ATIVIDADE DE $name João Victor Xavier da Silva",
        style = MaterialTheme.typography.bodyLarge.copy(
            fontWeight = FontWeight.Bold
        ),
        color = Color.White
    )
}

@Preview(showBackground = true)
@Composable
fun AppPreview() {
    LogcatButtonTheme {
        App()
    }
}