package com.example.repte02.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.repte02.R
import com.example.repte02.navigation.Routes
import com.example.repte02.viewmodel.Pantalla2ViewModel
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.rememberNavController
import com.example.repte02.ui.theme.Repte02Theme

@Composable
fun Pantalla2(
    navController: NavController,
    viewModel: Pantalla2ViewModel = viewModel()
) {
    val state by viewModel.state.collectAsState()
    
    val characters = listOf(
        R.drawable.goku,
        R.drawable.gomah,
        R.drawable.vegeta,
        R.drawable.piccolo,
        R.drawable.supreme,
        R.drawable.masked_majin
    )

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
        
        Text("Selecciona tu personaje", modifier = Modifier.padding(bottom = 16.dp))
        
        LazyVerticalGrid(
            columns = GridCells.Fixed(2),
            contentPadding = PaddingValues(16.dp),
            horizontalArrangement = Arrangement.spacedBy(16.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp),
            modifier = Modifier.weight(1f)
        ) {
            items(characters) { characterRes ->
                val index = characters.indexOf(characterRes)
                Image(
                    painter = painterResource(id = characterRes),
                    contentDescription = "Personaje ${index + 1}",
                    modifier = Modifier
                        .size(150.dp)
                        .border(
                            width = if (state.selectedCharacter == index) 4.dp else 1.dp,
                            color = if (state.selectedCharacter == index) Color.Blue else Color.Gray,
                            shape = RoundedCornerShape(8.dp)
                        )
                        .clickable { viewModel.selectCharacter(index) }
                )
            }
        }

        Button(
            onClick = { viewModel.navigateToScreen3 { navController.navigate(Routes.PANTALLA3) } },
            enabled = state.selectedCharacter != -1,
            modifier = Modifier.padding(16.dp)
        ) {
            Text("Continuar")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun Pantalla2Preview() {
    val navController = rememberNavController()
    Repte02Theme {
        Pantalla2(navController)
    }
} 