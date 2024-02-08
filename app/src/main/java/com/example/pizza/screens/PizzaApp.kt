package com.example.pizza.screens

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberUpdatedState
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.pizza.data.pizzaList

@Composable
fun PizzaApp (
    navController: NavHostController = rememberNavController()
) {
    NavHost(
        navController = navController,
        startDestination = PizzaAppScreens.Loading.name
    ) {
        composable(route = PizzaAppScreens.Loading.name) {
            LoadingScreen(onLoadingEnded = { navController.navigate(PizzaAppScreens.Main.name) })
        }
        composable(route = PizzaAppScreens.Main.name) {
            MainScreen(navController = navController)
        }
        composable(route = "${PizzaAppScreens.Pizza.name}/{id}") {back ->
            val i by rememberUpdatedState(back.arguments?.getString("id")?.toIntOrNull() ?: 0)
            PizzaScreen(
                pizza = pizzaList[i],
                id = i,
                navController = navController
            )
        }
    }
}


enum class PizzaAppScreens {
    Loading,
    Main,
    Pizza
}