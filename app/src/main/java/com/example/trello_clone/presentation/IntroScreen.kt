package com.example.trello_clone.presentation

import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.trello_clone.R
import com.example.trello_clone.ui.theme.PrimaryColor
import com.example.trello_clone.ui.theme.SecondaryColor

@Composable
fun IntroScreen(navController: NavController) {
    Column(
        modifier = Modifier
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = "Trello",
            color = PrimaryColor,
            style = MaterialTheme.typography.h3,
            fontWeight = FontWeight.Bold
        )
        Spacer(modifier = Modifier.height(20.dp))
        Image(
            modifier = Modifier.padding(horizontal = 20.dp) ,
            painter = painterResource(R.drawable.sign_up), contentDescription = "registration"
        )
        Spacer(modifier = Modifier.height(25.dp))
        Text(
            text = "Let's get started",
            color = Color.Gray,
            style = MaterialTheme.typography.h6,
            fontWeight = FontWeight.Bold
        )
        Spacer(modifier = Modifier.height(40.dp))

        val signInGradient = Brush.horizontalGradient(listOf(SecondaryColor, PrimaryColor))
        val signUPGradient = Brush.horizontalGradient(listOf(Color.Transparent, Color.Transparent))
        val modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp, vertical = 8.dp)

        AuthButton(
            modifier = modifier,
            gradient = signInGradient,
            text = "SIGN IN",
            textColor = Color.White,
            borderColor = Color.Transparent,
            onClick = {
                navController.navigate(Screen.LoginScreen.route)
            }
        )

        Spacer(modifier = Modifier.height(10.dp))

        AuthButton(
            modifier = modifier,
            gradient = signUPGradient,
            text = "SIGN UP",
            textColor = PrimaryColor,
            borderColor = PrimaryColor,
            onClick = {
                navController.navigate(Screen.RegistrationScreen.route)
            }
        )
    }
}

@Composable
fun AuthButton(
    modifier: Modifier,
    gradient: Brush,
    text: String,
    textColor: Color,
    borderColor: Color,
    onClick: () -> Unit
) {
    Box(
        modifier = modifier
            .background(gradient)
            .border(BorderStroke(2.dp, borderColor))
            .clickable {
                onClick()
            }
            .then(modifier),
        contentAlignment = Alignment.Center,
    ) {
        Text(
            text = text,
            color = textColor,
            style = MaterialTheme.typography.h6
        )
    }
}
