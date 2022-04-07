package com.example.trello_clone.presentation

import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.navigation.NavController

@Composable
fun HomeScreen(navController: NavController) {
    Text(text = "Hello World")
    Button(
        onClick = {
            navController.navigate(Screen.ProfileScreen.route)
        }
    ) {
        Text(text = "Go to Profile Screen")
    }
}