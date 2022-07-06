package com.bell_kenz.firstcomposeproject.ui.screens

import androidx.compose.animation.animateContentSize
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.bell_kenz.firstcomposeproject.R
import com.bell_kenz.firstcomposeproject.ui.domain.Message


@Composable
fun ConversationsScreen(messages: List<Message>, navController: NavController) {
    LazyColumn {
        items(messages) { message ->
            MessageCard(message,navController)

        }
    }

}


@Composable
fun MessageCard(message: Message, navController: NavController) {
    Row(
        Modifier
            .padding(8.dp)
            .clickable {
            }

    ) {
        Image(
            painterResource(id = R.drawable.anya),
            contentDescription = "Anya",
            Modifier
                .size(56.dp)
                .clip(CircleShape)
                .border(width = 1.dp, color = Color.Black, shape = CircleShape)
                .clickable {
                    navController.navigate(Screen.DetailsScreen.route)
                },
            contentScale = ContentScale.Crop
        )
        Spacer(Modifier.size(3.dp))

        var isExpanded by remember {
            mutableStateOf(false)
        }

        Column {
            Text(
                text = message.sender,
                color = colorResource(id = R.color.black),
                fontSize = 20.sp
            )
            Spacer(modifier = Modifier.size(4.dp))
            Card(
                shape = RoundedCornerShape(4.dp),
                elevation = 2.dp,
                modifier = Modifier
                    .fillMaxWidth(fraction = 0.4f)
                    .animateContentSize()
                    .padding(1.dp)
                    .clickable {
                        isExpanded = !isExpanded
                    }) {
                Text(
                    text = message.content,
                    color = colorResource(id = R.color.black),
                    fontSize = 16.sp,
                    modifier = Modifier.padding(8.dp),
                    maxLines = if (isExpanded) Int.MAX_VALUE else 1
                )
            }
        }

    }


}