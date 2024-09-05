package com.example.experiment5

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.experiment5.ui.theme.Experiment5Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Experiment5Theme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    LaunchEffect()
                }
            }
        }
    }
}

@Composable

fun LaunchEffect() { var counter by remember { mutableStateOf(0)

}

    val context = LocalContext.current
    LaunchedEffect(key1 = true) {
        Toast.makeText(context, "new state", Toast.LENGTH_SHORT).show()
    }

    Column(

        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement

        = Arrangement.Center

    ) {

        Text(text = "22MCA20020")
        Spacer(modifier = Modifier.size(50.dp))

        Button(onClick = { counter++ }) {
            Text(text = "click me", color
            = Color.Black)

        }

        Text(text = "counter")
        Text(text = "$counter", color=Color.Red

        )
        Spacer(modifier = Modifier

            .size(300.dp))

        Text(text = "learning point")
        Text(text = "1. configrution change value reset")
        Text(text = "2. toast message set")
        Text(text = "3. lunch effect")
        Text(text = "4. remember function")
    }
}


@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    Experiment5Theme {
        LaunchEffect()
    }
}