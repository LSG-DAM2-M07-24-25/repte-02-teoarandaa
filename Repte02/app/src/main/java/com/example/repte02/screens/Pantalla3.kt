package com.example.repte02.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.repte02.navigation.Routes
import com.example.repte02.viewmodel.Pantalla3ViewModel
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.rememberNavController
import com.example.repte02.R
import com.example.repte02.ui.theme.Repte02Theme

@Composable
fun Pantalla3(
    navController: NavController,
    characterIndex: Int,
    viewModel: Pantalla3ViewModel = viewModel()
) {
    val state by viewModel.state.collectAsState()

    LaunchedEffect(characterIndex) {
        viewModel.updateSelectedCharacter(characterIndex)
    }

    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = painterResource(id = R.drawable.dragonball_daima_logo),
            contentDescription = "Dragon Ball Daima Logo",
            modifier = Modifier
                .height(200.dp)
                .width(300.dp)
        )

        TextField(
            value = state.playerName,
            onValueChange = { viewModel.updatePlayerName(it) },
            label = { Text("Nombre del personaje") },
            modifier = Modifier.padding(vertical = 16.dp),
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Text,
                imeAction = ImeAction.Done
            )
        )

        Button(
            onClick = { 
                println("Navegando desde Pantalla3: characterIndex=${state.selectedCharacter}, playerName=${state.playerName}")
                val route = Routes.PANTALLA_FINAL
                    .replace("{characterIndex}", state.selectedCharacter.toString())
                    .replace("{playerName}", state.playerName)
                navController.navigate(route)
            },
            enabled = state.playerName.isNotBlank(),
            modifier = Modifier.padding(top = 16.dp)
        ) {
            Text("Comenzar")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun Pantalla3Preview() {
    val navController = rememberNavController()
    Repte02Theme {
        Pantalla3(
            navController = navController,
            characterIndex = 0
        )
    }
} 