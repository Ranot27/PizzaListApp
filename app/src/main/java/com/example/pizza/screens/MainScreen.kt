package com.example.pizza.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.pizza.R
import com.example.pizza.data.Pizza
import com.example.pizza.data.pizzaList
import com.example.pizza.ui.theme.PizzaTheme
import com.example.pizza.ui.theme.lightOrange
import com.example.pizza.ui.theme.mainOrange
import com.example.pizza.ui.theme.whiteBack
import com.example.pizza.ui.theme.whiteOnCard

@Composable
fun MainScreen(
    navController: NavController,
    modifier: Modifier = Modifier
) {
    PizzaTheme {
        PizzaList(navController = navController)
    }
}


@Composable
fun PizzaList(
    modifier: Modifier = Modifier,
    navController: NavController,
){
    LazyColumn(
        modifier = modifier
            .fillMaxSize()
            .background(Brush.verticalGradient(listOf(whiteBack, Color.White)))
    ) {
        itemsIndexed(pizzaList) {id, pizza ->
            pizzaCard(
                pizza = pizza,
                id = id,
                modifier = modifier.padding(horizontal = 32.dp, vertical = 8.dp),
                navController = navController
            )
        }
    }

}


@Composable
fun pizzaCard(
    pizza: Pizza,
    id: Int,
    modifier: Modifier = Modifier,
    navController: NavController,
){

    Box (
        modifier = modifier.fillMaxWidth(),
        contentAlignment = Alignment.CenterStart
    ) {
        Box (
            Modifier.padding(start = 30.dp)
        ) {
            PizzaDescription(
                pizza = pizza,
                modifier = Modifier
                    .background(color = mainOrange, shape = RoundedCornerShape(28.dp))
                    .padding(start = 130.dp, end = 0.dp, top = 6.dp, bottom = 6.dp)
                    .height(110.dp),
                navController = navController,
                id = id
            )
        }

        Image(
            painter = painterResource(id = pizza.imageId),
            contentDescription = null,
            Modifier.size(160.dp)
        )

    }

}

@Composable
fun PizzaDescription(
    pizza: Pizza,
    id: Int,
    modifier: Modifier = Modifier,
    navController: NavController,
) {
    Column (
        modifier = modifier,
        verticalArrangement = Arrangement.SpaceEvenly
    ) {
        Text(
            text = pizza.name,
            color = Color.White,
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold
        )
        Text(
            text = stringResource(id = pizza.ingredients),
            color = whiteOnCard,
            fontSize = 7.sp,
            lineHeight = 10.sp
        )
        Text(
            text = stringResource(R.string.pizza_size_35),
            color = whiteOnCard,
            fontSize = 7.sp
        )
        Row (
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = "от ${pizza.price.toString()}₽",
                color = Color.White,
                fontSize = 12.sp
            )
            Spacer(modifier = Modifier.weight(1f))
            Button(
                onClick = { navController.navigate("${PizzaAppScreens.Pizza.name}/${id}") },
                shape = RoundedCornerShape(14.dp),
                colors = ButtonDefaults.buttonColors(containerColor = Color.White),
                modifier = Modifier.height(25.dp).padding(end = 12.dp),
                contentPadding = PaddingValues(vertical = 4.dp, horizontal = 8.dp)
            ) {
                Text(
                    text = stringResource(R.string.choose_button),
                    color = Color.Black,
                    fontSize = 12.sp
                )
            }
        }
    }
}
