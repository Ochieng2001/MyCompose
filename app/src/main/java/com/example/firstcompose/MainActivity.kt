package com.example.firstcompose

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.firstcompose.ui.theme.FirstComposeTheme
import androidx.compose.foundation.layout.Row as Row
import androidx.compose.ui.Modifier.Companion as Modifier1

class MainActivity : ComponentActivity() {
    @SuppressLint("UnusedMaterialScaffoldPaddingParameter")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            FirstComposeTheme {

       Scaffold(
           topBar = {
               TopAppBar(
                   backgroundColor = Color.White,
                   title =

                   {
                        Row(modifier=Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.SpaceBetween,
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Image(
                                painter = painterResource(id = R.drawable.images), contentDescription =null )
                            Icon(imageVector = Icons.Default.Notifications, contentDescription =null )
                        }
                   }
               )
                   }
               ) {
           LazyRow(){
               items(4){
                   Card(modifier = Modifier.fillMaxWidth().size(200.dp)) {
                       Image(painter = painterResource(id = R.drawable.profile), contentDescription = null)
                   }
               }
           }


       }

        }
    }
}

}