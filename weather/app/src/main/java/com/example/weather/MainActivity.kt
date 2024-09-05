package com.example.weather

import android.content.Context
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.MaterialTheme.colors
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material3.CardDefaults
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.android.volley.Request
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.toolbox.Volley
import com.example.weather.ui.theme.WeatherTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TemperatureFetch()


        }
    }
}
@Preview
@Composable
fun TemperatureFetch() {
    var weatherData by remember { mutableStateOf<WeatherData?>(null) }
    val context = LocalContext.current
    var isLoading by remember { mutableStateOf(true) }
    val url = "http://api.weatherstack.com/current?access_key=fa77aab10fae4b20162c37acc a8126e0&query=Kharar"
    val request = JsonObjectRequest(
        Request.Method.GET, url, null,
        { response -> val location = response.getJSONObject("location")
            val current = response.getJSONObject("current")
            val city = location.getString("name")
            val description = current.getJSONArray("weather_descriptions").getString(0)

            val temperature =current.getDouble("temperature")
            val wIcon = current.getJSONArray("weather_icons").getString(0)
            val visibility = current.getInt("visibility")
            val precip = current.getInt("precip")
            val wind = current.getInt("wind_speed")
            weatherData = WeatherData(city, temperature, description,wIcon,visibility,precip,wind)
            isLoading = false
        },
        { error ->
            Toast.makeText( context,
                "Error getting weather data: ${error.message}",
                Toast.LENGTH_LONG
            ).show()
            weatherData = null
            isLoading = false
        })

    Volley.newRequestQueue(context).add(request)
    if (isLoading) {
        Column(
            modifier = Modifier.fillMaxSize().background(Color.LightGray),
            horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.Center
        ) {
            CircularProgressIndicator()
        }
    } else
    { Temperature( weatherData,context)
    }
}

@Composable

fun Temperature(weatherData: WeatherData?, context: Context) {
    Column(modifier =Modifier.background(Color.LightGray).fillMaxSize(),
        horizontalAlignment=Alignment.CenterHorizontally
    ) {
        Card( modifier = Modifier.fillMaxWidth().padding(16.dp),
            colors =  CardDefaults.cardColors(MaterialTheme.colorScheme.inversePrimary), elevation = CardDefaults.cardElevation(5.dp),
            shape = MaterialTheme.shapes.large,
        ) {
            Column(modifier = Modifier.fillMaxWidth()
                .padding(16.dp),
                verticalArrangement = Arrangement.Center, horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Image(painter = rememberImagePainter("${weatherData?.wIcon}"), contentDescription = null,
                    Modifier.size(100.dp).clip(RoundedCornerShape(percent = 50))
                )
                Text( text = "${weatherData?.temperature}° C", fontSize = 52.sp,
                    color = MaterialTheme.colorScheme.primary, fontWeight = FontWeight.Bold
                )
                Row {
                    Icon(imageVector = Icons.Default.LocationOn, contentDescription = null)
                    Text( fontSize = 20.sp,
                        text = "${weatherData?.city}"
                    )
                }
                Spacer(modifier = Modifier.size(10.dp))
                Text( text = "It looks ${weatherData?.description}.", fontSize = 20.sp,
                    color = MaterialTheme.colorScheme.primary, fontWeight = FontWeight.Bold
                )
            }
        }
        Card( modifier = Modifier.fillMaxWidth().padding(16.dp), colors == CardDefaults.cardColors(MaterialTheme.colorScheme.inversePrimary), elevation = CardDefaults.cardElevation(5.dp), shape
        = MaterialTheme.shapes.large,
        ) {
        Row( modifier = Modifier.fillMaxWidth(), horizontalArrangement
        = Arrangement.SpaceEvenly,
        ) {
            Column ( horizontalAlignment = Alignment.CenterHorizontally
            ){
                Text( fontSize = 20.sp,
                    text = "${weatherData?.visi} KM")
                Icon(painterResource(id = R.drawable.baseline_remove_red_eye_24),
                    contentDescription = null,
                    Modifier.size(40.dp))
            }
            Column ( horizontalAlignment = Alignment.CenterHorizontally
            ){
                Text( fontSize = 20.sp,
                    text= "${weatherData?.wind} KM/H")
                Image(painterResource(id = R.drawable.wind), contentDescription = null, Modifier.size(40.dp))
            }
            Column ( horizontalAlignment = Alignment.CenterHorizontally
            ){
                Text( fontSize = 20.sp, text= "${weatherData?.prec} MM")
                Icon(painterResource(id = R.drawable.drizzle), contentDescription = null, Modifier.size(40.dp))
            }
        }
    }
        Button( onClick = {
            Toast.makeText(context, "Refreshed", Toast.LENGTH_SHORT).show()
        },
            modifier = Modifier.padding(8.dp).align(Alignment.CenterHorizontally).offset(y = 300.dp)
        ) {
            Text(text = "Refresh")
        }
    }
}
data class WeatherData( val city: String,
                        val temperature: Double, val description: String, val
                        wIcon: String, val visi: Int, val prec:Int, val wind:Int
)

