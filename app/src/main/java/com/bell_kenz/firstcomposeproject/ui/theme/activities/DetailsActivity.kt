package com.bell_kenz.firstcomposeproject.ui.theme.activities

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.BiasAlignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.drawWithContent
import androidx.compose.ui.graphics.BlendMode
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.Constraints
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.bell_kenz.firstcomposeproject.R
import com.bell_kenz.firstcomposeproject.ui.theme.FirstComposeProjectTheme
import com.google.accompanist.systemuicontroller.rememberSystemUiController

class DetailsActivity : ComponentActivity() {

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
                    ProfileBackDropImage()
                }

            }

        }
    }

    @Composable
    private fun ProfileBackDropImage() {
        Box(
            modifier = Modifier
                .fillMaxWidth(1f)
                .fillMaxHeight(0.4f),
        ) {
            Image(
                painterResource(
                    id = R.drawable.bg_spy_x_family_one
                ),
                contentDescription = "",
                modifier = Modifier
                    .fillMaxWidth(1f)
                    .fillMaxHeight(.35f)
                    .graphicsLayer { alpha = 0.99F }
                    .drawWithContent {
                        val colors = listOf(Color.Transparent, Color.Black)
                        drawContent()
                        drawRect(
                            brush = Brush.verticalGradient(colors),
                            blendMode = BlendMode.DstOut
                        )
                    }
                ,
                alignment = Alignment.TopCenter,
                contentScale = ContentScale.FillBounds
            )
            Row(
                Modifier
                    .fillMaxWidth(1f)
                    .fillMaxHeight(0.25f)
                    .align(BiasAlignment(0.5f, -0.4f))
                    .align(Alignment.Center)
            ) {
                Image(
                    painterResource(id = R.drawable.anya_shock),
                    contentDescription = "Anya",
                    Modifier
                        .padding(16.dp)
                        .size(144.dp)
                        .clip(CircleShape)
                        .border(width = 1.dp, color = Color.Black, shape = CircleShape),
                    contentScale = ContentScale.Crop
                )
                Column(modifier = Modifier
                    .fillMaxSize().padding(top = 24.dp),
                       verticalArrangement = Arrangement.Center
                ) {
                    Text(
                        text = "Anya Forger",
                        fontSize = 56.sp,
                        fontFamily = FontFamily(Font(R.font.main_font))
                    )
                    Text(
                        text = "\"I want peanuts\"",
                        fontStyle = FontStyle.Italic,
                        fontSize = 32.sp,
                        fontFamily = FontFamily(Font(R.font.main_font))

                    )


                }




            }
        }


    }
}