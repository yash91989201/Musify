package com.example.musify.ui.theme

import android.os.Build
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.dynamicDarkColorScheme
import androidx.compose.material3.dynamicLightColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext

private val LightColorScheme = lightColorScheme(
    primary = Teal,
    secondary = Aqua,
    background = White,
    surface = LightGray,
    onPrimary = White,
    onBackground = AlmostBlack,
    onSurface = AlmostBlack,
)

private val DarkColorScheme = darkColorScheme(
    primary = Teal,
    secondary = Aqua,
    background = AlmostBlack,
    surface = Charcoal,
    onPrimary = AlmostBlack,
    onBackground = LightGray,
    onSurface = LightGray,
)

@Composable
fun MusifyTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    val colorScheme = when {
        Build.VERSION.SDK_INT >= Build.VERSION_CODES.S -> {
            val context = LocalContext.current
            if (darkTheme) dynamicDarkColorScheme(context) else dynamicLightColorScheme(context)
        }

        darkTheme -> DarkColorScheme
        else -> LightColorScheme
    }

    MaterialTheme(
        colorScheme = colorScheme,
        typography = Typography,
        content = content
    )
}