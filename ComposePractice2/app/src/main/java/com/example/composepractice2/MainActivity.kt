package com.example.composepractice2

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
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import com.example.composepractice2.ui.theme.ComposePractice2Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {

        }
    }
}

@Preview(showBackground = true, widthDp = 300, heightDp = 500)
@Composable
private fun previewFunction(){
    Text(
        text = "Hello....... My New Compose ",
        fontStyle = FontStyle.Italic,

        fontWeight = FontWeight.ExtraBold,
        color = Color.Red,
        fontSize = 34.sp,
        textAlign = TextAlign.Right


    )
}

