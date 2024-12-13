package com.example.repte02.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.material3.ButtonDefaults
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.repte02.R
import com.example.repte02.viewmodel.PantallaFinalViewModel
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.rememberNavController
import com.example.repte02.navigation.Routes
import com.example.repte02.ui.theme.Repte02Theme

@Composable
private fun PantallaFinalContent(
    characterIndex: Int,
    playerName: String,
    characters: List<Int>,
    navController: NavController
) {

    val buttonModifier = Modifier
        .padding(16.dp)
        .fillMaxWidth(0.5f)
        .height(48.dp)

    val buttonColors = ButtonDefaults.buttonColors(
        containerColor = Color.Gray,
        contentColor = Color.White
    )
    val buttonShape = RoundedCornerShape(8.dp)

    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = painterResource(id = R.drawable.dragonball_daima_logo),
            contentDescription = "Dragon Ball Daima Logo",
            modifier = Modifier
                .padding(16.dp)
                .height(200.dp)
                .width(400.dp)
        )

        Column(
            modifier = Modifier.weight(1f),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Image(
                painter = painterResource(
                    id = characters.getOrElse(characterIndex) { R.drawable.goku }
                ),
                contentDescription = "Personaje seleccionado",
                modifier = Modifier
                    .size(300.dp)
                    .padding(16.dp)
            )

            Text(
                text = playerName,
                fontSize = 32.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(top = 24.dp)
            )
        }

        Button(
            onClick = { navController.navigate(Routes.PANTALLA2) },
            modifier = buttonModifier,
            colors = buttonColors,
            shape = buttonShape

        ) {
            Text("Volver")
        }
    }
}

@Composable
fun PantallaFinal(
    navController: NavController,
    characterIndex: Int,
    playerName: String,
    viewModel: PantallaFinalViewModel = viewModel()
) {
    val characters = listOf(
        R.drawable.goku,
        R.drawable.gomah,
        R.drawable.vegeta,
        R.drawable.piccolo,
        R.drawable.supreme,
        R.drawable.masked_majin
    )

    LaunchedEffect(characterIndex, playerName) {
        viewModel.updateState(characterIndex, playerName)
    }

    val state by viewModel.state.collectAsState()

    PantallaFinalContent(
        characterIndex = state.selectedCharacter,
        playerName = state.playerName,
        characters = characters,
        navController = navController
    )
}

@Preview(showBackground = true)
@Composable
fun PantallaFinalPreview() {
    val characters = listOf(
        R.drawable.goku,
        R.drawable.gomah,
        R.drawable.vegeta,
        R.drawable.piccolo,
        R.drawable.supreme,
        R.drawable.masked_majin
    )
    
    Repte02Theme {
        PantallaFinalContent(
            characterIndex = 0,
            playerName = "Jugador de prueba",
            characters = characters,
            navController = rememberNavController()
        )
    }
} 