package com.example.trello_clone.presentation

import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import com.google.firebase.auth.FirebaseAuth

@Composable
fun ProfileScreen(navController: NavController, auth: FirebaseAuth) {
    Text(text = "Profile Screen")
    Button(
        onClick = {
            auth.signOut()
            navController.navigate(Screen.IntroScreen.route) {
                popUpTo(0)
            }
        }
    ) {
        Text(text = "Log out")
    }
}