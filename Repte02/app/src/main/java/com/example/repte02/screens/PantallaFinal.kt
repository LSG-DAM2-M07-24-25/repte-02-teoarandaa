package com.example.repte02.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
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
import com.example.repte02.ui.theme.Repte02Theme

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

    LaunchedEffect(Unit) {
        viewModel.updateState(characterIndex, playerName)
    }

    val state by viewModel.state.collectAsState()

    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = painterResource(id = R.drawable.dragonball_daima_logo),
            contentDescription = "Dragon Ball Daima Logo",
            modifier = Modifier
                .padding(16.dp)
                .height(100.dp)
        )

        Spacer(modifier = Modifier.height(32.dp))
        
        Text(
            text = "¡Bienvenido ${state.playerName}!",
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(bottom = 16.dp)
        )

        Image(
            painter = painterResource(
                id = characters[state.selectedCharacter]
            ),
            contentDescription = "Personaje seleccionado",
            modifier = Modifier
                .size(200.dp)
                .padding(16.dp)
        )

        Text(
            text = "Has elegido a ${getCharacterName(state.selectedCharacter)}",
            fontSize = 20.sp,
            modifier = Modifier.padding(top = 16.dp)
        )
    }
}

private fun getCharacterName(index: Int): String {
    return when(index) {
        0 -> "Goku"
        1 -> "Gohan"
        2 -> "Vegeta"
        3 -> "Piccolo"
        4 -> "Supreme"
        5 -> "Masked Majin"
        else -> "Desconocido"
    }
}

@Preview(showBackground = true)
@Composable
fun PantallaFinalPreview() {
    val navController = rememberNavController()
    Repte02Theme {
        PantallaFinal(
            navController = navController,
            characterIndex = 0,
            playerName = "Jugador"
        )
    }
} 