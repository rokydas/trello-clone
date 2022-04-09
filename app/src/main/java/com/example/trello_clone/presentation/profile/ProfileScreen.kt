package com.example.trello_clone.presentation

import android.content.Context
import android.util.Log
import android.widget.Toast
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.runtime.*
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.DialogProperties
import androidx.lifecycle.LifecycleCoroutineScope
import androidx.navigation.NavController
import com.example.trello_clone.R
import com.example.trello_clone.model.User
import com.example.trello_clone.ui.theme.PrimaryColor
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import androidx.lifecycle.viewModelScope
import com.example.trello_clone.presentation.profile.ProfileViewModel

@Composable
fun ProfileScreen(navController: NavController, auth: FirebaseAuth) {

    val userId = auth.uid
    val context = LocalContext.current
    val viewModel = ProfileViewModel()

    var isLoading by rememberSaveable { mutableStateOf(true) }

    val user = viewModel.user.observeAsState()
    if(user.value != null) {
        isLoading = false
    }

    if(userId != null) {
        viewModel.getUser(userId)
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
    ) {
        if(isLoading) {
            Dialog(
                onDismissRequest = {  },
                DialogProperties(dismissOnBackPress = false, dismissOnClickOutside = false)
            ) {
                Box(
                    contentAlignment= Alignment.Center,
                    modifier = Modifier
                        .size(100.dp)
                        .background(Color.Transparent, shape = RoundedCornerShape(8.dp))
                ) {
                    CircularProgressIndicator(color = PrimaryColor)
                }
            }
        }
        else {
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
                        text = user.value!!.name,
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
                    text = user.value!!.email,
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
                    .clickable {
                        auth.signOut()
                        navController.navigate(Screen.IntroScreen.route) {
                            popUpTo(0)
                        }
                    }
            ) {
                Icon(
                    imageVector = Icons.Default.Logout, contentDescription = "",
                    tint = Color.Red,
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
}