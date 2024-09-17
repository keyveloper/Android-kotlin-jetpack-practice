package com.example.jetpack_compose_practice.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NamedNavArgument
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.jetpack_compose_practice.screens.MovieScreens
import com.example.jetpack_compose_practice.screens.details.DetailsScreen
import com.example.jetpack_compose_practice.screens.home.HomeScreen

@Composable
fun MovieNavigation() {
    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = MovieScreens.HomeScreen.name
    ) {
        composable(
            MovieScreens.HomeScreen.name
        ) {
            // here we pass where this should lead us to
            HomeScreen(
                navController = navController
            )
        }

        composable(
            MovieScreens.DetailsScreen.name + "/{movie}", // argument added
            arguments = listOf(
                navArgument("movie") { type = NavType.StringType }
            )
        ) {
            backStackEntry ->
            DetailsScreen(
                navController = navController,
                movieName = backStackEntry.arguments?.getString("movie")
            )
        }
    }
}