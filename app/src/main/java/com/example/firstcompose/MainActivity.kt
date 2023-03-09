package com.example.firstcompose

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.Star
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.firstcompose.ui.theme.FirstComposeTheme

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
                   elevation = 0.dp,
                   title =

                   {
                        Row(
                            modifier= Modifier
                                .fillMaxWidth()
                                .size(50.dp)
                                .clip(CircleShape),
                            horizontalArrangement = Arrangement.SpaceBetween,
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Image(

                                painter = painterResource(id = R.drawable.profile),
                                contentDescription =null
                            )
                            Icon(
                                imageVector = Icons.Default.Notifications,
                                contentDescription =null )
                        }
                   }
               )
                   }
               ) {
           LazyColumn(
               modifier = Modifier
                   .fillMaxWidth()
                   .padding(24.dp)
           ){
               item {
                   LazyRow(modifier = Modifier.fillMaxWidth()){
                       items(mountain){ mountain ->
                           MountainCard(mountain)
                       }

                   }
               }
               item {

                   Spacer(modifier = Modifier.height(24.dp))

                   Row(
                       modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween
                   ){
                       Text(text = "Best Destination")
                       Text(text = "View All")
                   }
               }

               item {
                   LazyRow(
                       modifier = Modifier.fillMaxWidth()

                   ){
                        items(Destination){ Destination ->
                            Card(
                                modifier = Modifier
                                    .background(Color.Gray)
                                    .padding(8.dp)

                            ) {
                                Image(
                                painter = painterResource(id = Destination.Image),
                                    contentDescription = null
                                )
                                Text(

                                    text = Destination.name
                                )

                            }
                        }
                   }
               }
           }



       }

        }
    }
}



    
    @Composable
    fun MountainCard(mountain: Mountain) {
        Card(modifier = Modifier
            .width(12.dp)
            .height(12.dp)
            .padding(23.dp)

        ) {
            Box(

                modifier = Modifier.fillMaxWidth()
                    //.wrapContentHeight(align = Alignment.Bottom)
            ) {
                Image(
                    painter = painterResource(id = mountain.Image),
                    contentDescription = null,
                    contentScale = ContentScale.Crop
                )

                Text(text = mountain.name)
                Text(text = mountain.location)
            }

        }
    }

}

@Preview
@Composable
fun BestDestination.BestDestination() {
    Card(modifier = Modifier
        .width(12.dp)
        .height(12.dp)

        .padding(8.dp),
        shape = RoundedCornerShape(15.dp)
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentHeight(align = Alignment.Bottom)

        ) {
            Image(
                modifier = Modifier.fillMaxWidth(),
                painter = painterResource(id = Image),
                contentDescription = null,
                contentScale = ContentScale.Crop
            )

            Text(
                text = name
            )
            Icon(imageVector = Icons.Default.LocationOn, contentDescription = null)
        }
        Icon(

            imageVector = Icons.Default.Star,
            contentDescription = null)

    }
}

data class Mountain(
    val Image: Int,
    val name: String,
    val location: String,
    val rating: Float,
)

val mountain = listOf(
    Mountain(
        Image = R.drawable.login,
        name = "Kilimanjaro",
        location = "Nairobi, Kenya",
        rating = 4.5f,
    ),
    Mountain(
        Image = R.drawable.orderimag,
        name = "Everest",
        location = "Mombai, India",
        rating = 4.6f,
    ),
    Mountain(
        Image = R.drawable.icon,
        name = "Kenya",
        location = "Meru, Kenya",
        rating = 4.7f,
    ),
    Mountain(
        Image = R.drawable.images,
        name = "Elgon",
        location = "Nairobi, Kenya",
        rating = 4.8f,
    ),
    Mountain(
        Image = R.drawable.login,
        name = "Nangio",
        location = "Juba, Tz",
        rating = 4.9f,
    )

)

data class BestDestination(
    val Image: Int,
    val name: String,
    val location: String,
    val rating: Float
)

val Destination = listOf(
    BestDestination(
        Image = R.drawable.login,
        name = "Kilimanjaro",
        location = "Nairobi, Kenya",
        rating = 4.5f,
    ),
    BestDestination(
        Image = R.drawable.orderimag,
        name = "Everest",
        location = "Mombai, India",
        rating = 4.6f,
    ),
    BestDestination(
        Image = R.drawable.icon,
        name = "Kenya",
        location = "Meru, Kenya",
        rating = 4.7f,
    ),
    BestDestination(
        Image = R.drawable.images,
        name = "Elgon",
        location = "Nairobi, Kenya",
        rating = 4.8f,
    ),
    BestDestination(
        Image = R.drawable.login,
        name = "Panagio",
        location = "Jubal, Tz",
        rating = 4.9f,
    )

)
