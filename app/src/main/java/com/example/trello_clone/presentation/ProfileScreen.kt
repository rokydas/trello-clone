package com.example.trello_clone.presentation

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Divider
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.trello_clone.R
import com.google.firebase.auth.FirebaseAuth

@Composable
fun ProfileScreen(navController: NavController, auth: FirebaseAuth) {
    Column(
        modifier = Modifier
            .fillMaxSize()
    ) {
        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier
                .fillMaxWidth()
                .padding(30.dp)
        ) {
            Icon(
                imageVector = Icons.Default.ArrowBack, contentDescription = "back",
                modifier = Modifier
                    .clickable {
                        navController.popBackStack()
                    }
            )
            Icon(
                imageVector = Icons.Default.Edit, contentDescription = "undate profile",
                modifier = Modifier
                    .clickable {
                        navController.navigate(Screen.UpdateProfileScreen.route)
                    }
            )
        }
        Spacer(modifier = Modifier.height(10.dp))
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .padding(start = 30.dp)
        ) {
            Image(
                painter = painterResource(R.drawable.profile),
                contentDescription = "profile_picture",
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .size(100.dp)
                    .clip(CircleShape)
                    .border(2.dp, Color.Gray, CircleShape)
            )

            Spacer(modifier = Modifier.width(30.dp))

            Column {
                Text(
                    text = "Emma Phillips",
                    style = MaterialTheme.typography.h5,
                    fontWeight = FontWeight.Bold
                )
                Text(
                    text = "Fashion Model",
                    style = MaterialTheme.typography.body1
                )
            }
        }
        Spacer(modifier = Modifier.height(30.dp))
        Row(
            modifier = Modifier
                .padding(start = 30.dp)
        ) {
            Icon(
                imageVector = Icons.Default.Call, contentDescription = "",
                tint = Color.Gray
            )
            Spacer(modifier = Modifier.width(30.dp))
            Text(
                text = "+88055656563",
                style = MaterialTheme.typography.body1
            )
        }
        Spacer(modifier = Modifier.height(10.dp))
        Row(
            modifier = Modifier
                .padding(start = 30.dp)
        ) {
            Icon(
                imageVector = Icons.Default.Mail, contentDescription = "",
                tint = Color.Gray
            )
            Spacer(modifier = Modifier.width(30.dp))
            Text(
                text = "emma.phillips@gmail.com",
                style = MaterialTheme.typography.body1
            )
        }
        Spacer(modifier = Modifier.height(40.dp))
        Divider(color = Color.Gray, thickness = 2.dp)
        Row(
            horizontalArrangement = Arrangement.SpaceEvenly,
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .fillMaxWidth()
                .height(IntrinsicSize.Min)
        ) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier
                    .padding(vertical = 15.dp)
            ) {
                Text(
                    text = "15",
                    style = MaterialTheme.typography.h5
                )
                Text(
                    text = "Total Tasks",
                    style = MaterialTheme.typography.body1
                )
            }
            Divider(
                color = Color.Gray,
                modifier = Modifier
                    .fillMaxHeight()
                    .width(2.dp)
            )
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier
                    .padding(vertical = 15.dp)
            ) {
                Text(
                    text = "10",
                    style = MaterialTheme.typography.h5
                )
                Text(
                    text = "Remaining Tasks",
                    style = MaterialTheme.typography.body1
                )
            }
        }
        Divider(color = Color.Gray, thickness = 2.dp)
        Spacer(modifier = Modifier.height(20.dp))
        Row(
            modifier = Modifier
                .padding(start = 30.dp)
        ) {
            Icon(
                imageVector = Icons.Default.Logout, contentDescription = "",
                tint = Color.Red
            )
            Spacer(modifier = Modifier.width(30.dp))
            Text(
                text = "Log out",
                color = Color.Red,
                style = MaterialTheme.typography.h6
            )

        }
    }
}