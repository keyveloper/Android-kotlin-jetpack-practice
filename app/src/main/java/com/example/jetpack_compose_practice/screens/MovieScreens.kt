package com.example.jetpack_compose_practice.screens

// www.google.com/sign_un
enum class MovieScreens {
    HomeScreen,
    DetailsScreen;

    companion object {
        fun fromRoute(route: String?): MovieScreens
         = when (route?.substringBefore("/")) {
             HomeScreen.name -> HomeScreen
             DetailsScreen.name -> DetailsScreen
            null -> HomeScreen
            else -> throw IllegalArgumentException("Route $route is not recognized")
         }
    }
}