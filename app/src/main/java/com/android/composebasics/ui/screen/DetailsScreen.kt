package com.android.composebasics.ui.screen

import android.R
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import com.android.composebasics.data.PetData

@Composable
fun DetailsScreen(navController: NavController, petData: PetData) {
    //Text("${petData.name}")
    Scaffold (
        topBar = {
                TopAppBar (
                    navigationIcon= {
                        IconButton(onClick = { navController.popBackStack() }) {
                            Icon(imageVector = Icons.Filled.ArrowBack,contentDescription = null, tint= Color.White)
                    }
                    },
                    modifier = Modifier.height(69.dp),
                    title = { Text(text = "Puppies", textAlign = TextAlign.Center, modifier = Modifier.fillMaxWidth())},
                    actions = { IconButton(onClick = { /*TODO*/ }) {
                        Icon(imageVector = Icons.Filled.Favorite, contentDescription = null, tint = Color.White)
                    }},
                    elevation = 0.dp,
                    backgroundColor = Color.DarkGray,
                    contentColor = Color.White,

                )
        },
        bottomBar = {}
    ){
    }
}