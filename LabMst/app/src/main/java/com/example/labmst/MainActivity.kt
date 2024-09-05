package com.example.labmst



import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Surface(color = Color.White) {

                ScaffoldExample()
            }
        }
    }
}
@Preview
@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun ScaffoldExample() {


    val scaffoldState = rememberScaffoldState(rememberDrawerState(DrawerValue.Closed))


    val coroutineScope = rememberCoroutineScope()


    Scaffold(


        scaffoldState = scaffoldState,


        topBar = {
            TopBar(

                onMenuClicked = {
                    coroutineScope.launch {

                        scaffoldState.drawerState.open()
                    }
                })
        },


        bottomBar = { BottomBar() },


        content = { Body() },


        drawerContent = {
            Drawer()
        },

        floatingActionButton = {

            FloatingActionButton(
                onClick = {

                    coroutineScope.launch {
                        when (scaffoldState.snackbarHostState.showSnackbar(

                            message = "Snack Bar",
                            actionLabel = "Dismiss"
                        )) {
                            SnackbarResult.Dismissed -> {

                            }

                            SnackbarResult.ActionPerformed -> {

                            }

                        }
                    }
                }) {

                Text(text = "X")
            }
        }
    )
}


@Composable
fun TopBar(onMenuClicked: () -> Unit) {

    TopAppBar(

        title = {
            Text(text = "Scaffold||GFG", color = Color.White)
        },

        navigationIcon = {
            Icon(
                imageVector = Icons.Default.Menu,
                contentDescription = "Menu",


                modifier = Modifier.clickable(onClick = onMenuClicked),
                tint = Color.White
            )
        },

        backgroundColor = Color(0xFF0F9D58)
    )
}

@Composable
fun BottomBar() {

    BottomAppBar(
        backgroundColor = Color(0xFF0F9D58)
    ) {
        Text(text = "Bottom App Bar", color = Color.White)
    }
}

@Composable
fun Body() {
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
    ) {
        Text(text = "Body Content", color = Color(0xFF0F9D58))
    }
}


@Composable
fun Drawer() {
    // Column Composable
    Column(
        Modifier
            .background(Color.White)
            .fillMaxSize()
    ) {

        repeat(5) { item ->
            Text(text = "Item number $item", modifier = Modifier.padding(8.dp), color = Color.Black)
        }
    }
}
