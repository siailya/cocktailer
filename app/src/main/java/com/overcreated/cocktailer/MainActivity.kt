package com.overcreated.cocktailer

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.rememberNavController
import com.overcreated.cocktailer.navigation.BottomNavigation
import com.overcreated.cocktailer.navigation.NavigationGraph
import com.overcreated.cocktailer.navigation.TopNavigation
import com.overcreated.cocktailer.ui.theme.CocktailerTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CocktailerTheme() {
                MainView()
            }
        }
    }
}


@Preview(showBackground = true)
@Composable
fun MainView() {
    val navController = rememberNavController()
    Scaffold(
        bottomBar = { BottomNavigation(navController = navController) },
        topBar = { TopNavigation(navController = navController) }
    ) {
        NavigationGraph(navController = navController)
    }
}