package com.example.trello_clone

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.trello_clone.presentation.*
import com.example.trello_clone.ui.theme.Trello_cloneTheme
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser




class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val auth: FirebaseAuth = FirebaseAuth.getInstance()

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
                            HomeScreen(navController = navController, auth)
                        }
                        composable(route = Screen.ProfileScreen.route) {
                            ProfileScreen(navController = navController, auth)
                        }
                        composable(route = Screen.SplashScreen.route) {
                            SplashScreen(navController = navController, auth)
                        }
                        composable(route = Screen.IntroScreen.route) {
                            IntroScreen(navController = navController)
                        }
                        composable(route = Screen.RegistrationScreen.route) {
                            RegistrationScreen(navController = navController, auth)
                        }
                        composable(route = Screen.LoginScreen.route) {
                            LoginScreen(navController = navController, auth)
                        }
                    }
                }
            }
        }
    }
}