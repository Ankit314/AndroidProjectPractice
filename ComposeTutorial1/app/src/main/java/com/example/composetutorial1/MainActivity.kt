package com.example.composetutorial1

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.composetutorial1.ui.theme.ComposeTutorial1Theme

class MainActivity : ComponentActivity()
{
    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContent{




        }
    }
}
@Preview(showBackground = true, widthDp = 300, heightDp = 500)
@Composable
private fun prevewfunction(){

    Column {

        ListViewItem(R.drawable.apple,"Apple","Mobile Phone")
        ListViewItem(R.drawable.facebook,"Facebook","Social Media Website")
        ListViewItem(R.drawable.google,"Google","Search Engine")
        ListViewItem(R.drawable.instagram,"Instagram","Social Media")
        ListViewItem(R.drawable.linkedin,"Linkedin","Job Search platform")
        ListViewItem(R.drawable.twitter,"Twitter","Social Media Platform")
        ListViewItem(R.drawable.telegram,"Telegram","Chat Application")
        ListViewItem(R.drawable.whatsapp,"Whatsapp","Chat Application")
        ListViewItem(R.drawable.youtube,"Youtube","Social Media Video Platform")
        
    }






}
@Composable
fun ListViewItem(ImgId:Int,name:String,occupation:String){

    Row(Modifier.padding(10.dp)) {
        Image(painter = painterResource(id =  ImgId), contentDescription ="",Modifier.size(40.dp) )

        Column() {

            Text(text = name, fontWeight = FontWeight.Bold)
            Text(text = occupation, fontWeight = FontWeight.Thin, fontSize = 12.sp)

            
        }


        
    }


}


