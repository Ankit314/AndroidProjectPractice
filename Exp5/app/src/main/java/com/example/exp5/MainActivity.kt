package com.example.exp5

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.exp5.ui.theme.Exp5Theme
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.withContext

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComplexComposable()


        }
    }
}
@Preview
@Composable
fun ComplexComposable() {
    // Create a ViewModel to hold the state
    val viewModel: MyViewModel = viewModel()

    // Create a coroutine scope
    val coroutineScope = rememberCoroutineScope()

    Column(modifier = Modifier.fillMaxSize()) {
        var complexState by remember { mutableStateOf(ComplexState()) }

        // Trigger a coroutine when the Composable is first composed
        LaunchedEffect(true) {
            // Perform a suspend function in the IO dispatcher
            val result = withContext(Dispatchers.IO) {
                // Call a suspend function, e.g., make a network request
                performNetworkRequest()
            }

            // Update UI with the result
            complexState = result
        }

        // UI elements that use complexState
    }
}

// Sample suspend function
suspend fun performNetworkRequest(): ComplexState {
    // Simulate a network request delay
    delay(2000)

    // Replace with actual network request code
    return ComplexState()
}

// ViewModel class for storing and updating UI state
class MyViewModel : ViewModel() {
    // Define and update your UI state as needed
    fun updateUI(result: ComplexState) {

        // Update your UI state here
    }
}

data class ComplexState(val someValue: String = "Initial Value")