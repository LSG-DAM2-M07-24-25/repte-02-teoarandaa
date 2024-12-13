package com.example.repte02

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.repte02.navigation.Routes
import com.example.repte02.screens.Pantalla1
import com.example.repte02.screens.Pantalla2
import com.example.repte02.screens.Pantalla3
import com.example.repte02.ui.theme.Repte02Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Repte02Theme {
                val navController = rememberNavController()
                
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    NavHost(
                        navController = navController,
                        startDestination = Routes.PANTALLA1,
                        modifier = Modifier.padding(innerPadding)
                    ) {
                        composable(Routes.PANTALLA1) {
                            Pantalla1(navController)
                        }
                        composable(Routes.PANTALLA2) {
                            Pantalla2(navController)
                        }
                        composable(Routes.PANTALLA3) {
                            Pantalla3(navController)
                        }
                    }
                }
            }
        }
    }
}