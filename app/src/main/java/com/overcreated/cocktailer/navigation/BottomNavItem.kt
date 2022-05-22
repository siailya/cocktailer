package com.overcreated.cocktailer.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.*
import androidx.compose.ui.graphics.vector.ImageVector

sealed class BottomNavItem(var title: String, var icon: ImageVector, var screen_route: String){

    object Cocktails : BottomNavItem("Коктейли", Icons.Rounded.LocalBar,"cocktails")
    object Calculator: BottomNavItem("Калькулятор", Icons.Rounded.Calculate, "calculator")
    object Shake: BottomNavItem("Намешать", Icons.Rounded.Receipt, "shake")
    object Profile: BottomNavItem("Профиль", Icons.Rounded.AccountCircle, "profile")
}