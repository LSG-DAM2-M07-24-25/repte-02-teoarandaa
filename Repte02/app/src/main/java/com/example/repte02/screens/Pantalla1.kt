package com.example.repte02.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.repte02.navigation.Routes
import com.example.repte02.viewmodel.Pantalla1ViewModel
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.rememberNavController
import com.example.repte02.R
import com.example.repte02.ui.theme.Repte02Theme
import androidx.compose.material3.ButtonDefaults
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.ui.graphics.Color

@Composable
fun Pantalla1(
    navController: NavController,
    viewModel: Pantalla1ViewModel = viewModel()
) {
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Image(
            painter = painterResource(id = R.drawable.dragonball_daima_logo),
            contentDescription = "Dragon Ball Daima Logo",
            modifier = Modifier
                .height(500.dp)
                .width(700.dp)

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

        Button(
            onClick = { viewModel.navigateToScreen2 { navController.navigate(Routes.PANTALLA2) } },
            modifier = buttonModifier,
            colors = buttonColors,
            shape = buttonShape
        ) {
            Text("Entrar")
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