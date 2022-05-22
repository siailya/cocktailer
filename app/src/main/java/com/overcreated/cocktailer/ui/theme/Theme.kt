package com.overcreated.cocktailer.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.MaterialTheme
import androidx.compose.material.darkColors
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

private val DarkColorPalette = darkColors(
    primary = AccentRedLight,
    primaryVariant = AccentRedLight,
    secondary = AccentRedLight,
    background = DarkBackground,
    secondaryVariant = DarkSecondaryBackground,
    onSecondary = Color.White,
)

private val LightColorPalette = lightColors(
    primary = AccentRed,
    primaryVariant = AccentRed,
    secondary = AccentRedLight,
    background = Color.White,
    secondaryVariant = Color.White,
    onSecondary = Color.Black,


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
fun CocktailerTheme(darkTheme: Boolean = isSystemInDarkTheme(), content: @Composable () -> Unit) {
    val colors = if (darkTheme) {
        DarkColorPalette
    } else {
        LightColorPalette
    }

    MaterialTheme(
        colors = colors,
        typography = Typography,
        shapes = Shapes,
        content = content
    )
}