package com.example.trello_clone.presentation

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.trello_clone.R
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import kotlinx.coroutines.delay

@Composable
fun SplashScreen(navController: NavController, auth: FirebaseAuth) {

    LaunchedEffect(key1 = true) {
        delay(1000)
        navController.popBackStack()

        val currentUser: FirebaseUser? = auth.currentUser

        if(currentUser == null) {
            navController.navigate(Screen.IntroScreen.route)
        } else {
            navController.navigate(Screen.ProfileScreen.route)
        }
    }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(50.dp),
        contentAlignment = Alignment.Center
    ) {
        Image(painterResource(R.drawable.ic_trello_logo),"trello logo")
    }

}