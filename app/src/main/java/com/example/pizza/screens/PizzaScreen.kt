package com.example.pizza.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.pizza.data.Pizza
import com.example.pizza.data.pizzaList
import com.example.pizza.ui.theme.mainOrange
import com.example.pizza.ui.theme.pizzaDescription

@Composable
fun PizzaScreen(
    pizza: Pizza,
    id: Int,
    navController: NavController,
    modifier: Modifier = Modifier
) {
    Column (
        modifier = modifier.fillMaxSize().padding(32.dp),
        horizontalAlignment = Alignment.Start,
        verticalArrangement = Arrangement.SpaceEvenly
    ) {
        Image(
            painter = painterResource(id = pizza.imageId),
            contentDescription = null,
            modifier = Modifier.size(256.dp).align(Alignment.CenterHorizontally)
        )
        Text(
            text = pizza.name,
            fontSize = 32.sp,
            color = mainOrange,
            fontWeight = FontWeight.Bold
        )
        Text(
            text = "Состав: ${stringResource(id = pizza.ingredients)}",
            fontSize = 16.sp,
            color = pizzaDescription
            )
        Text(
            text = stringResource(id = pizza.description),
            fontSize = 16.sp,
            color = pizzaDescription
        )
        Text(
            text = "${pizza.size.toString()} см",
            fontSize = 16.sp,
            color = pizzaDescription
        )

        val startIndex = if (id < 9) id else id - 6

        Column (
            modifier = modifier.fillMaxWidth().align(Alignment.CenterHorizontally),

        ) {
            Row (
                horizontalArrangement = Arrangement.SpaceBetween,
                modifier = modifier.fillMaxWidth()
            ) {
                PizzaImage(id = startIndex + 1, navController = navController)
                PizzaImage(id = startIndex + 2, navController = navController)
                PizzaImage(id = startIndex + 3, navController = navController)
            }
            Row (
                horizontalArrangement = Arrangement.SpaceBetween,
                modifier = modifier.fillMaxWidth().padding(top = 6.dp)
            ) {
                PizzaImage(id = startIndex + 4, navController = navController)
                PizzaImage(id = startIndex + 5, navController = navController)
                PizzaImage(id = startIndex + 6, navController = navController)
            }
        }
    }
}


@Composable
fun PizzaImage(
    id: Int,
    navController: NavController
) {
    Image(
        painter = painterResource(id = pizzaList[id].imageId),
        contentDescription = null,
        modifier = Modifier
            .clickable {
                navController.navigate( route = "${PizzaAppScreens.Pizza.name}/${id}") {
                    launchSingleTop = true
                    popUpToId
                }
            }
            .size(80.dp)
    )
}

