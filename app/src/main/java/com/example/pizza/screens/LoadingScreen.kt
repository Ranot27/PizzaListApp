package com.example.pizza.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.pizza.R
import com.example.pizza.ui.theme.PizzaLoadingTheme
import com.example.pizza.ui.theme.PizzaTheme
import com.example.pizza.ui.theme.lightOrange
import com.example.pizza.ui.theme.mainOrange
import kotlinx.coroutines.delay

@Composable
fun LoadingScreen(
    modifier: Modifier = Modifier,
    onLoadingEnded: () -> Unit
) {
    PizzaLoadingTheme{
        Box (
            modifier = modifier
                .fillMaxSize()
                .background(Brush.verticalGradient(listOf(lightOrange, mainOrange))),
        ) {
            Column (
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Spacer(modifier = Modifier.weight(0.6f))
                Image(
                    painter = painterResource(id = R.drawable.loading_pizza),
                    contentDescription = null,
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .fillMaxHeight()
                        .padding(top = 32.dp)
                        .weight(5f)
                )
                Spacer(modifier = Modifier.weight(1f))
                Text(
                    text = stringResource(R.string.loding),
                    modifier = Modifier,
                    fontSize = 48.sp,
                    color = Color.White
                )
                LoadingIndicator(
                    modifier = Modifier.padding(8.dp),
                    onLoadingEnded = onLoadingEnded
                )
                Spacer(modifier = Modifier.weight(0.5f))
            }
        }
    }
}


@Composable
fun LoadingIndicator(
    modifier: Modifier = Modifier,
    onLoadingEnded: () -> Unit
) {
    var currentProgress by remember { mutableFloatStateOf(0f) }

    LaunchedEffect(key1 = 1) {
        for (i in 1..50) {
            currentProgress = i.toFloat() / 50
            delay(100)
        }
        onLoadingEnded()
    }

    Surface (
        shape = MaterialTheme.shapes.medium,
        modifier = modifier
            .padding(horizontal = 48.dp)
            .fillMaxWidth()
            .height(20.dp)
    ) {
        Surface (
            shape = MaterialTheme.shapes.medium,
            modifier = Modifier.fillMaxSize()
        ) {
            LinearProgressIndicator(
                progress = currentProgress,
                color = Color.White,
                trackColor = mainOrange,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 0.dp, top = 2.dp, bottom = 2.dp, end = 2.dp),
                strokeCap = StrokeCap.Round
            )
        }
    }
}
















