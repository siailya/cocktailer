package com.overcreated.cocktailer.navigation

import android.util.Log
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.overcreated.cocktailer.ui.theme.AccentRed

@Composable
fun BottomNavigation(navController: NavController) {
    val items = listOf(
        BottomNavItem.Cocktails,
        BottomNavItem.Calculator,
        BottomNavItem.Shake,
        BottomNavItem.Profile
    )
    androidx.compose.material.BottomNavigation(
        backgroundColor = AccentRed,
        contentColor = Color.White
    ) {
        val navBackStackEntry by navController.currentBackStackEntryAsState()
        val currentRoute = navBackStackEntry?.destination?.route
        items.forEach { item ->
            BottomNavigationItem(
                icon = { Icon(item.icon, contentDescription = item.title) },
                label = { Text(text = item.title, fontSize = 9.sp) },
                selectedContentColor = Color.White,
                unselectedContentColor = Color.White.copy(0.4f),
                alwaysShowLabel = true,
                selected = currentRoute == item.screen_route,
                onClick = {
                    navController.navigate(item.screen_route) {

                        navController.graph.startDestinationRoute?.let { screen_route ->
                            popUpTo(screen_route) {
                                saveState = true
                            }
                        }
                        if (currentRoute != null) {
                            Log.d("INFO", currentRoute)
                        }
                        launchSingleTop = true
                        restoreState = true
                    }
                }
            )
        }
    }
}