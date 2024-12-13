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
import com.example.repte02.viewmodel.Pantalla1ViewModel
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.rememberNavController
import com.example.repte02.ui.theme.Repte02Theme

@Composable
fun Pantalla1(
    navController: NavController,
    viewModel: Pantalla1ViewModel = viewModel()
) {
    val state by viewModel.state.collectAsState()

    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(text = state.message)
        Button(
            onClick = { viewModel.navigateToScreen2 { navController.navigate(Routes.PANTALLA2) } },
            modifier = Modifier.padding(top = 16.dp)
        ) {
            Text("Ir a Pantalla 2")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun Pantalla1Preview() {
    val navController = rememberNavController()
    Repte02Theme {
        Pantalla1(navController)
    }
} 