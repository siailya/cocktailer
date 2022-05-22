package com.overcreated.cocktailer.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.overcreated.cocktailer.screens.CalculatorScreen
import com.overcreated.cocktailer.screens.CocktailsScreen
import com.overcreated.cocktailer.screens.ProfileScreen
import com.overcreated.cocktailer.screens.ShakeScreen

@Composable
fun NavigationGraph(navController: NavHostController) {
    NavHost(navController, startDestination = BottomNavItem.Cocktails.screen_route) {
        composable(BottomNavItem.Cocktails.screen_route) {
            CocktailsScreen()
        }
        composable(BottomNavItem.Calculator.screen_route) {
            CalculatorScreen()
        }
        composable(BottomNavItem.Shake.screen_route) {
            ShakeScreen()
        }
        composable(BottomNavItem.Profile.screen_route) {
            ProfileScreen()
        }
    }
}