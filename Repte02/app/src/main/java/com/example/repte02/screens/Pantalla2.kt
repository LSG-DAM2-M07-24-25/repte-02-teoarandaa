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
import androidx.compose.material3.ButtonDefaults
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
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import androidx.compose.ui.layout.ContentScale

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
                .height(200.dp)
                .width(400.dp)
        )
        
        Text(
            text = "Selecciona tu personaje",
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(vertical = 16.dp)
        )
        
        LazyVerticalGrid(
            columns = GridCells.Fixed(3),
            contentPadding = PaddingValues(horizontal = 24.dp, vertical = 16.dp),
            horizontalArrangement = Arrangement.spacedBy(24.dp),
            verticalArrangement = Arrangement.spacedBy(24.dp),
            modifier = Modifier
                .weight(1f)
                .fillMaxWidth()
        ) {
            items(characters) { characterRes ->
                val index = characters.indexOf(characterRes)
                Box(
                    modifier = Modifier
                        .aspectRatio(0.8f)
                        .fillMaxWidth()
                        .border(
                            width = if (state.selectedCharacter == index) 4.dp else 1.dp,
                            color = if (state.selectedCharacter == index) Color.Blue else Color.Gray,
                            shape = RoundedCornerShape(12.dp)
                        )
                        .clickable { viewModel.selectCharacter(index) }
                        .padding(12.dp)
                ) {
                    Image(
                        painter = painterResource(id = characterRes),
                        contentDescription = "Personaje ${index + 1}",
                        modifier = Modifier.fillMaxSize(),
                        contentScale = ContentScale.Fit
                    )
                }
            }
        }

        Button(
            onClick = { 
                val route = Routes.PANTALLA3
                    .replace("{characterIndex}", state.selectedCharacter.toString())
                navController.navigate(route)
            },
            enabled = state.selectedCharacter != -1,
            modifier = buttonModifier,
            colors = buttonColors,
            shape = buttonShape
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