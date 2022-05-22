package com.overcreated.cocktailer.navigation

import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Search
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState

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
        backgroundColor = MaterialTheme.colors.primary,
        title = { Text(routeName) },
        contentColor = Color.White,
        actions = {
            Icon(Icons.Rounded.Search, "search")
        }
    )
}