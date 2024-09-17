package com.example.jetpack_compose_practice.screens.details

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

@Composable
fun DetailsScreen(
    navController: NavController,
    movieName: String?) {
    Text(
        text = movieName.toString(),
        modifier = Modifier.padding(top = 20.dp))
}