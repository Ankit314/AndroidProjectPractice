package com.example.composepractice1

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.composepractice1.ui.theme.ComposePractice1Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            
            Text(text = "Hello Ankit ")


        }
    }
}


@Composable
fun Greeting(name:String="Jai Shree Ram"){
    Text(text = "$name  Hello Compse")
}

@Preview(showBackground = true, name = "Good Morning", showSystemUi = true)
@Composable
private fun Gree(){
    Greeting("New Function")

}

