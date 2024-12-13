package com.example.repte02

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.repte02.navigation.Routes
import com.example.repte02.screens.Pantalla1
import com.example.repte02.screens.Pantalla2
import com.example.repte02.screens.Pantalla3
import com.example.repte02.screens.PantallaFinal
import com.example.repte02.ui.theme.Repte02Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Repte02Theme {
                val navController = rememberNavController()
                NavHost(navController = navController, startDestination = Routes.PANTALLA1) {
                    composable(Routes.PANTALLA1) {
                        Pantalla1(navController)
                    }
                    composable(Routes.PANTALLA2) {
                        Pantalla2(navController)
                    }
                    composable(
                        route = Routes.PANTALLA3,
                        arguments = listOf(
                            navArgument("characterIndex") { type = NavType.IntType }
                        )
                    ) { backStackEntry ->
                        val characterIndex = backStackEntry.arguments?.getInt("characterIndex") ?: 0
                        Pantalla3(navController, characterIndex)
                    }
                    composable(
                        route = Routes.PANTALLA_FINAL,
                        arguments = listOf(
                            navArgument("characterIndex") { 
                                type = NavType.IntType
                                nullable = false  // No permitir nulos
                            },
                            navArgument("playerName") { 
                                type = NavType.StringType
                                nullable = false  // No permitir nulos
                            }
                        )
                    ) { backStackEntry ->
                        println("Debug - Navegando a PantallaFinal")
                        val characterIndex = backStackEntry.arguments?.getInt("characterIndex") ?: 0
                        val playerName = backStackEntry.arguments?.getString("playerName") ?: ""
                        println("Debug - Datos recibidos: characterIndex=$characterIndex, playerName=$playerName")
                        
                        PantallaFinal(
                            navController = navController,
                            characterIndex = characterIndex,
                            playerName = playerName
                        )
                    }
                }
            }
        }
    }
}