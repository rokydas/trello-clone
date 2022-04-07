package com.example.trello_clone

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.trello_clone.presentation.*
import com.example.trello_clone.ui.theme.Trello_cloneTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Trello_cloneTheme {
                Surface(
                    color = MaterialTheme.colors.background
                ) {
                    val navController = rememberNavController()
                    NavHost (
                        navController = navController,
                        startDestination = Screen.SplashScreen.route,
                    ) {
                        composable(route = Screen.HomeScreen.route) {
                            HomeScreen(navController = navController)
                        }
                        composable(route = Screen.ProfileScreen.route) {
                            ProfileScreen(navController = navController)
                        }
                        composable(route = Screen.SplashScreen.route) {
                            SplashScreen(navController = navController)
                        }
                        composable(route = Screen.RegistrationScreen.route) {
                            IntroScreen(navController = navController)
                        }
                    }
                }
            }
        }
    }
}