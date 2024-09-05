package com.example.exp4

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import androidx.compose.ui.graphics.Color // Import this line
import com.example.exp4.ui.theme.Exp4Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            GreetingBox()
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Preview
@Composable fun GreetingBox() {
    var username by remember { mutableStateOf("") }

    Column {
        Text(text = "Hello, $username", fontSize = 24.sp) // Corrected fontsize parameter
        OutlinedTextField(
            value = username,
            onValueChange = { username = it }
        )
    }
}
