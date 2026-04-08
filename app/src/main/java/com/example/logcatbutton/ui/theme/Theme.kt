package com.example.logcatbutton.ui.theme

import android.os.Build
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.dynamicDarkColorScheme
import androidx.compose.material3.dynamicLightColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext

private val DarkColorScheme = darkColorScheme(
    primary = Color.White,
    secondary = PurpleGrey80,
    tertiary = Pink80,
    background = MatteBlack,
    surface = MatteBlack,
    onBackground = Color.White,
    onSurface = Color.White,
    onPrimary = MatteBlack
)

@Composable
fun LogcatButtonTheme(
    darkTheme: Boolean = true,
    dynamicColor: Boolean = false,
    content: @Composable () -> Unit
) {

    val colorScheme = DarkColorScheme

    MaterialTheme(
        colorScheme = colorScheme,
        typography = Typography,
        content = content
    )
}

@Composable
fun DebugButtonColors() = ButtonDefaults.buttonColors(
    containerColor = Color.Transparent,
    contentColor = Color.White
)

@Composable
fun WarningButtonColors() = ButtonDefaults.buttonColors(
    containerColor = Color.Transparent,
    contentColor = Color.White
)

@Composable
fun ErrorButtonColors() = ButtonDefaults.buttonColors(
    containerColor = Color.Transparent,
    contentColor = Color.White
)

@Composable
fun InfoButtonColors() = ButtonDefaults.buttonColors(
    containerColor = Color.Transparent,
    contentColor = Color.White
)