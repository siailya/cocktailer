package com.overcreated.cocktailer.navigation

import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.overcreated.cocktailer.ui.theme.AccentRed

@Composable
fun TopNavigation(navController: NavController) {
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val routeName = when (navBackStackEntry?.destination?.route) {
        "cocktails" -> "Коктейлер"
        "calculator" -> "Калькулятор градуса"
        "shake" -> "Намешать коктейль"
        "profile" -> "Профиль и настройки"
        else -> "Коктейлер!"
    }


    TopAppBar(
        backgroundColor = AccentRed,
        title = { Text(routeName) },
        contentColor = Color.White,
    )
}