package com.example.repte02.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
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

    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(text = state.message)
        Button(
            onClick = { viewModel.navigateToScreen3 { navController.navigate(Routes.PANTALLA3) } },
            modifier = Modifier.padding(top = 16.dp)
        ) {
            Text("Ir a Pantalla 3")
        }
        Button(
            onClick = { viewModel.navigateBack { navController.navigateUp() } },
            modifier = Modifier.padding(top = 8.dp)
        ) {
            Text("Volver")
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