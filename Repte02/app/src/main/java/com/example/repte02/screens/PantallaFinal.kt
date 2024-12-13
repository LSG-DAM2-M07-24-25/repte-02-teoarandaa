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
    println("PantallaFinal - characterIndex: $characterIndex, playerName: $playerName")

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
        characters = characters
    )
}

@Composable
private fun PantallaFinalContent(
    characterIndex: Int,
    playerName: String,
    characters: List<Int>
) {
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
            text = "¡Bienvenido $playerName!",
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(bottom = 16.dp)
        )

        Image(
            painter = painterResource(
                id = characters.getOrElse(characterIndex) { R.drawable.goku }
            ),
            contentDescription = "Personaje seleccionado",
            modifier = Modifier
                .size(200.dp)
                .padding(16.dp)
        )

        Text(
            text = "Has elegido a ${getCharacterName(characterIndex)}",
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
            characters = characters
        )
    }
} 