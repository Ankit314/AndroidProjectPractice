package com.example.compose_1

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
import com.example.compose_1.ui.theme.Compose_1Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Text(text = "Ankit")




        }
    }
}
@Composable
fun sh(name: String){
    Text(text = "Boliye $name")
}
@Preview(showBackground = true, showSystemUi = true, widthDp = 200, heightDp = 200, name = "Message_1")
@Composable
private fun showPreview(){
    sh(name = "Jai Shree Ram")

}