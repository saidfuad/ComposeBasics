package com.android.composebasics

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
//import androidx.compose.ui.Modifier
import androidx.compose.ui.*
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.navArgument
import androidx.navigation.compose.rememberNavController
import com.android.composebasics.data.PetData
import com.android.composebasics.data.PetList
import com.android.composebasics.ui.screen.DetailsScreen
import com.android.composebasics.ui.screen.HomeScreen
import com.android.composebasics.ui.theme.ComposeBasicsTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            //Text("Hello world!")
            ComposeBasicsTheme {
                // A surface container using the 'background' color from the theme

                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.primary
                ) {

                }
                //App
                MyApp()
            }
        }
    }
}

@Composable
fun MyApp(){
    val navController = rememberNavController()
NavHost(navController = navController, startDestination = "home" ){
    //Each screen is a composable
    composable(route="home"){
        HomeScreen(navController)
         }
    composable("details/{dogIndex", arguments= listOf(navArgument("dogIndex"){type = NavType.IntType}) ){
        val dogIndex = it.arguments?.getInt("dogIndex") ?:0
       // DetailsScreen(navController, PetListData = PetList[dogIndex])
    }
    }
}