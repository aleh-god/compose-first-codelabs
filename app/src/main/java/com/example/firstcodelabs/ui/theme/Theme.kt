package com.example.firstcodelabs.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.MaterialTheme
import androidx.compose.material.darkColors
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable

// TODO("3.3 Для цветов объявляются 2 палитры c помощью методов darkColors и lightColors.")
// Эти методы создадут объект Colors, который как раз является одним из важнейших компонентов MaterialTheme.
private val DarkColorPalette = darkColors(
    primary = PinkLight,
    primaryVariant = Red,
    secondary = Navy
)

private val LightColorPalette = lightColors(
    primary = Pink,
    primaryVariant = Red,
    secondary = Navy

    /* Other default colors to override
    background = Color.White,
    surface = Color.White,
    onPrimary = Color.White,
    onSecondary = Color.Black,
    onBackground = Color.Black,
    onSurface = Color.Black,
    */
)

@Composable
fun FirstCodelabsTheme(
    // Запомните этот метод, его можно использовать не только для выбора цветовой палитры, но и для определения иконок, теней и т.д.
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    val colors = if (darkTheme) {
        DarkColorPalette
    } else {
        LightColorPalette
    }

    // TODO("3.1 MaterialTheme состоит из трех основных компонентов")
    MaterialTheme(
        colors = colors,
        typography = Typography,
        shapes = Shapes,
        content = content
    )
}