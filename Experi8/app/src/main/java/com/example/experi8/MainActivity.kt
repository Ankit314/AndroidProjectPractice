package com.example.experi8

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.experi8.ui.theme.Experi8Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {

            ChatApp()

        }
    }
}



@Composable
fun ChatApp() {
    var message by remember { mutableStateOf("") }
    var messages by remember {

        mutableStateOf(mutableListOf<String>())

    }

    Column(
        modifier = Modifier.fillMaxSize()
    ) {
        Column(
            modifier = Modifier
                .weight(1f)
                .background(Color.White)
        ) {
            // Display chat messages
            for (msg in messages) {
                ChatMessage(text = msg)
            }
        }

        Row(
            modifier = Modifier
                .background(Color.LightGray)
                .fillMaxWidth()
                .padding(8.dp)
        ) {
            BasicTextField(
                value = message,
                onValueChange = { message = it },
                textStyle = TextStyle(fontSize = 16.sp),
                modifier = Modifier
                    .weight(1f)
                    .padding(8.dp)
            )

            Spacer(modifier = Modifier.width(8.dp))

            Button(
                onClick = {
                    if (message.isNotEmpty()) {
                        messages.add(message)
                        message = ""
                    }
                },
                modifier = Modifier
                    .height(48.dp)
            ) {
                Text("Send")
            }
        }
    }
}

@Composable
fun ChatMessage(text: String) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
    ) {
        Text(
            text = text,
            fontSize = 16.sp,
            modifier = Modifier
                .background(Color.Blue)
                .padding(8.dp)
        )
    }
}

@Preview
@Composable
fun ChatAppPreview() {
    ChatApp()
}