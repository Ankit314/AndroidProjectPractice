package com.example.view_withcompose

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.ComposeView
import androidx.compose.ui.tooling.preview.Preview

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val composelayout=findViewById<ComposeView>(R.id.compose_layout)
        composelayout.setContent {
            sh(name = "jai Shree Ram")
        }
    }
}


@Composable



fun sh(name: String){
    Text(text = "Boliye $name")
}
