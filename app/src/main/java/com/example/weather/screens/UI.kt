package com.example.weather.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.example.weather.data.WeatherModel
import com.example.weather.ui.theme.CardBackground
import com.example.weather.ui.theme.TextColor

@Composable
fun ListItem(item: WeatherModel) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 5.dp),
        backgroundColor = CardBackground,
        elevation = 0.dp,
        shape = RoundedCornerShape(5.dp)
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Column(modifier = Modifier.padding(5.dp)) {
                Text(text = item.time, color = TextColor)
                Text(text = item.condition, color = TextColor)
            }
            Text(
                text = item.currentTemp.ifEmpty
                { "${item.maxTemp}/${item.minTemp}" },
                color = TextColor,
                style = TextStyle(fontSize = 25.sp)
            )
            AsyncImage(
                model = "https:${item.icon}", contentDescription = "Image_6",
                modifier = Modifier
                    .padding(end = 8.dp)
                    .size(30.dp)
            )
        }
    }
}

@Composable
fun MainList(list: List<WeatherModel>) {
    LazyColumn(modifier = Modifier.fillMaxSize()) {
        itemsIndexed(
            list
        ) { index, item -> ListItem(item) }
    }
}