package com.bell_kenz.firstcomposeproject.ui.activities

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.bell_kenz.firstcomposeproject.ui.domain.Message
import com.bell_kenz.firstcomposeproject.ui.screens.ConversationsScreen
import com.bell_kenz.firstcomposeproject.ui.screens.DetailsScreen
import com.bell_kenz.firstcomposeproject.ui.screens.Screen
import com.bell_kenz.firstcomposeproject.ui.theme.FirstComposeProjectTheme
import com.google.accompanist.systemuicontroller.rememberSystemUiController

class MainActivity : ComponentActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            rememberSystemUiController().apply {
                isStatusBarVisible = false
            }
            FirstComposeProjectTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    elevation = 0.dp,
                    color = Color.White

                ) {
                    val navController = rememberNavController()
                    NavHost(navController = navController, startDestination = Screen.ConversationsScreen.route ){
                        composable(route = Screen.ConversationsScreen.route){
                            ConversationsScreen(messages = getMessages(),navController)
                        }
                        composable(route = Screen.DetailsScreen.route){
                            DetailsScreen()
                        }


                    }

                }

            }
        }
    }
}


private fun getMessages(): List<Message> {


    return ArrayList<Message>().apply {
        add(Message("Anya", "Waku Waku!\nWaku Waku!\nWaku Waku!\nWaku Waku!\nWaku Waku!"))
        add(Message("Anya", "Peanuts!\nPeanuts!\nPeanuts!\nPeanuts!\nPeanuts!\nPeanuts!\nPeanuts!"))
        add(
            Message(
                "Anya",
                "Telibii\nTelibii\nTelibii\nTelibii\nTelibii\nTelibii\nTelibii\nTelibii"
            )
        )
        add(
            Message(
                "Anya", "Spy...mission...\n" +
                        "Spy...mission...\n" +
                        "Spy...mission...\nSpy...mission...\n" +
                        "Spy...mission...\nSpy...mission..."
            )
        )


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

        }

    }
}