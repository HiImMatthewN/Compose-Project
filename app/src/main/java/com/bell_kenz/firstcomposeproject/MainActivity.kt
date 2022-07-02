package com.bell_kenz.firstcomposeproject

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
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
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.max
import androidx.compose.ui.unit.sp
import com.bell_kenz.firstcomposeproject.ui.theme.FirstComposeProjectTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            FirstComposeProjectTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    Conversations(messages = getMessages())

                }
            }
        }
    }
}

@Composable
fun Conversations(messages: List<Message>) {
    LazyColumn {
        items(messages) { message ->
            MessageCard(message)

        }
    }

}

@Composable
fun MessageCard(message: Message) {
    Row(
        Modifier.padding(8.dp)
    ) {
        Image(
            painterResource(id = R.drawable.anya),
            contentDescription = "Anya",
            Modifier
                .size(56.dp)
                .clip(CircleShape)
                .border(width = 1.dp, color = Color.Cyan, shape = CircleShape),
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
                modifier = Modifier.fillMaxWidth(fraction = 0.4f)
                    .animateContentSize().padding(1.dp).
                       clickable { isExpanded = !isExpanded }) {
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

private fun getMessages(): List<Message> {


    return ArrayList<Message>().apply {
        add(Message("Anya", "Waku Waku!\nWaku Waku!\nWaku Waku!\nWaku Waku!\nWaku Waku!"))
        add(Message("Anya", "Peanuts!\nPeanuts!\nPeanuts!\nPeanuts!\nPeanuts!\nPeanuts!\nPeanuts!"))
        add(Message("Anya", "Telibii\nTelibii\nTelibii\nTelibii\nTelibii\nTelibii\nTelibii\nTelibii"))
        add(Message("Anya", "Spy...mission...\n" +
                "Spy...mission...\n" +
                "Spy...mission...\nSpy...mission...\n" +
                "Spy...mission...\nSpy...mission..."))


    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    FirstComposeProjectTheme {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colors.background
        ) {
//            MessageCard("Android")
        }

    }
}