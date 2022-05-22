package com.overcreated.cocktailer.components

import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.overcreated.cocktailer.ui.theme.AccentRed

@Composable
fun Headline(text: String) {
    Text(
        text = text,
        fontSize = 20.sp,
        fontWeight = FontWeight.Medium,
        modifier = Modifier
            .drawBehind {
                val strokeWidth = 2 * density
                val y = size.height - strokeWidth / 2

                drawLine(
                    AccentRed,
                    Offset(0f, y),
                    Offset(size.width, y),
                    strokeWidth,
                    alpha = 0.5f
                )
            }
            .padding(top = 24.dp)
    )
}