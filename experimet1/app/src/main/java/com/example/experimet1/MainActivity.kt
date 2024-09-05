package com.example.experimet1

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.tooling.preview.Preview
import com.example.experimet1.ui.theme.Experimet1Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
             TextCard("ankit")
        }
    }
}

@Composable
fun TextCard(name: String) {
    Text(text = "Hello $name!",
        color = Color.White,
        fontFamily = FontFamily.Monospace)
    
}

@Preview(showBackground = true)
@Composable
fun previewTextCard() {
    TextCard("Ankit")
}