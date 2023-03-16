package com.example.firstcompose

//import androidx.compose.foundation.layout.BoxScopeInstance.align
import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
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
                            modifier = Modifier
                                .fillMaxWidth(1f),
                            backgroundColor = Color.White,
                            elevation = 0.dp,
                            title = {
                                Row(
                                    modifier = Modifier
                                        .fillMaxWidth(1f),
                                    horizontalArrangement = Arrangement.SpaceBetween,
                                    verticalAlignment = Alignment.CenterVertically
                                ) {
                                    Image(
                                        modifier = Modifier
                                            .size(30.dp)
                                            .clip(shape = CircleShape),
                                        painter = painterResource(id = R.drawable.profile),
                                        contentDescription = null
                                    )
                                    Icon(
                                        imageVector = Icons.Default.Notifications,
                                        modifier = Modifier
                                            .clip(shape = CircleShape)
//                                            .background(Color.hsl(0.0f, 0.0f, 0.7f, .3f))
                                            .size(25.dp),
                                        contentDescription = null,
                                    )

                                }

                            }
                        )
                    }
                ) {

                    LazyColumn(

                        verticalArrangement = Arrangement.spacedBy(10.dp),
                        modifier = Modifier.fillMaxSize(1f)
                    )
                    {
                        item {
                            LazyRow(modifier = Modifier.fillMaxWidth(1f),) {
                                items(mountain) { mountain ->
                                    MountainViewBox(mountain)
                                }
                            }
                        }
                        item {
                            Row(
                                horizontalArrangement = Arrangement.SpaceBetween,
                                modifier = Modifier
                                    .fillMaxWidth(1f)
                                    .padding(horizontal = 8.dp, vertical = 0.dp)
                            ) {
                                Text(
                                    text = "Best Destination",
                                    fontWeight = FontWeight.Bold,
                                    fontSize = 18.sp
                                )
                                Text(
                                    text = "View All-->",
                                    fontSize = 14.sp,
                                    color = Color.Blue
                                )
                            }
                        }
                        item {
                            LazyVerticalGrid(
                                columns = GridCells.Fixed(count = 2),
                                modifier = Modifier
                                    .fillMaxWidth(1f)
                                    .height(370.dp)
                            )
                            {
                                items(mountain.size) { index ->
                                    MountainCell(mountain[index])
                                }
                            }
                        }




                    }

//                    Spacer(modifier = Modifier.height(20.dp))
//
//
//                    LazyVerticalGrid(
//                        Cells = GridCells.Fixed(2),
//                        modifier = Modifier
//                            .fillMaxWidth()
//                            .height(370.dp)
//                    )
//                    {
//                        items(boxContents.size) { index ->
//                            MountainCell(boxContents[index])
//                        }
//                    }
                }
            }
        }

    }
}

@Composable
private fun MountainViewBox(mountain: Mountain) {
    Box(
        modifier = Modifier
            .width(250.dp)
            .height(170.dp)
            .clip(shape = RoundedCornerShape(5.dp))
            .padding(8.dp)
            .background(Color.White)
    )
    {

        Image(
            painter = painterResource(id = mountain.BoxImage),
            modifier = Modifier
                .width(250.dp)
                .height(150.dp)
                .clip(shape = RoundedCornerShape(10.dp))
                .align(alignment = Alignment.BottomStart),
            contentDescription = null
        )
        Column(
            modifier = Modifier
                .padding(horizontal = 0.dp, vertical = 25.dp)
                .align(alignment = Alignment.BottomStart)

        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier
                    .padding(horizontal = 8.dp)
                    .fillMaxWidth(1f)
            ) {
                Text(
                    text = mountain.name,
                    color = Color.White,
                    fontWeight = FontWeight.Bold,
                    fontSize = 16.sp
                )
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.spacedBy(1.dp)
                ) {
                    Image(
                        painter = painterResource(id = mountain.ratingIcon),
                        modifier = Modifier.size(18.dp),
                        contentDescription = null
                    )
                    Text(
                        text = mountain.rating,
                        color = Color.White,
                        fontWeight = FontWeight.Bold,
                        fontSize = 16.sp
                    )
                }
            }
            Row(
                horizontalArrangement = Arrangement.spacedBy(2.dp),
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .padding(horizontal = 8.dp, vertical = 4.dp)
                    .fillMaxWidth(1f)
            ) {
                Icon(
                    imageVector = Icons.Default.LocationOn,
                    modifier = Modifier.size(18.dp),
                    tint = Color.White,
                    contentDescription = null,
                )
                Text(
                    text = mountain.city,
                    color = Color.White,
                    fontWeight = FontWeight.Light,
                    fontSize = 14.sp
                )
                Text(
                    text = mountain.country,
                    color = Color.White,
                    fontWeight = FontWeight.Light,
                    fontSize = 14.sp
                )

            }


        }

    }

}





@Composable
fun MountainCell(mountain: Mountain) {
    Box(
        modifier = Modifier
            .width(250.dp)
            .height(180.dp)
            .clip(shape = RoundedCornerShape(10.dp))
            .padding(8.dp)
            .background(Color.White)
    ) {
        Image(
            painter = painterResource(id = mountain.BoxImage),
            modifier = Modifier
                .clip(shape = RoundedCornerShape(12.dp))
                .width(250.dp)
                .height(120.dp)
                .align(Alignment.TopStart),
            contentDescription = null
        )
        Image(
            painter = painterResource(id = R.drawable.bookmark),
            modifier = Modifier
                .width(28.dp)
                .height(32.dp)
                .padding(0.dp, 14.dp, 8.dp, 0.dp)
                .align(Alignment.TopEnd)
                .clip(shape = CircleShape),
//                    .background(Color.hsl(0.0f, 0.0f, 0.6f, .8f)),
            contentDescription = null,
        )
        Column(
            modifier = Modifier
                .fillMaxWidth(1f)
                .align(Alignment.BottomStart)
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier
                    .fillMaxWidth(1f)
            ) {
                Text(
                    text = mountain.name,
                    color = Color.Black,
                    fontWeight = FontWeight.Bold,
                    fontSize = 12.sp
                )
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.spacedBy(0.9.dp),
                    modifier = Modifier.padding(vertical = 8.dp)
                ) {
                    Image(
                        painter = painterResource(id = mountain.ratingIcon),
                        modifier = Modifier.size(12.dp),
                        contentDescription = null
                    )
                    Text(
                        text = mountain.rating,
                        color = Color.Black,
                        fontWeight = FontWeight.Bold,
                        fontSize = 12.sp

                    )
                }
            }
            Row(
                horizontalArrangement = Arrangement.spacedBy(2.dp),
                verticalAlignment = Alignment.CenterVertically,
            ) {
                Image(
                    painter = painterResource(id = mountain.locationIcon),
                    modifier = Modifier.size(12.dp),
                    contentDescription = null,
                )
                Text(
                    text = mountain.city,
                    color = Color.Black,
                    fontSize = 12.sp
                )
                Text(
                    text = mountain.country,
                    color = Color.Black,
                    fontSize = 12.sp
                )

            }
        }
    }
}



data class Mountain(
    val BoxImage: Int,
    val ratingIcon: Int,
    val name: String,
    val city: String,
    val country: String,
    val locationIcon: Int,
    val rating: String

)

val mountain = listOf(
    Mountain(

        BoxImage = R.drawable.download5,
        ratingIcon = R.drawable.rating,
        rating = "4.9",
        name = " Souther Mountain",
        city = " Turgen,",
        country = "Singapo ",
        locationIcon = R.drawable.location

    ),
    Mountain(

        BoxImage = R.drawable.mountain1,
        ratingIcon = R.drawable.rating,
        rating = "5.0",
        name = " Longonot Mountain",
        city = "Zanzibar,",
        country = "Ethiopa ",
        locationIcon = R.drawable.location

    ),
    Mountain(

        BoxImage = R.drawable.mountains2,
        ratingIcon = R.drawable.rating,
        rating = "4.0",
        name = "Nandi Hills",
        city = " Nairobi, ",
        country = "Kenya ",
        locationIcon = R.drawable.location

    ),
    Mountain(

        BoxImage = R.drawable.mountain3,
        ratingIcon = R.drawable.rating,
        rating = "3.5",
        name = " Mt.Kenya Mountain",
        city = " Meru, ",
        country = "Kenya ",
        locationIcon = R.drawable.location,
    ),
    Mountain(

        BoxImage = R.drawable.mountain4,
        ratingIcon = R.drawable.rating,
        rating = "3.5",
        name = " Evarest Mountain",
        city = " Seattle, ",
        country = "Mexico ",
        locationIcon = R.drawable.location,
    ),
    Mountain(

        BoxImage = R.drawable.orderimag,
        ratingIcon = R.drawable.rating,
        rating = "3.5",
        name = " Kilimanjaro Mountain",
        city = " Tanganyika, ",
        country = "Tanzania ",
        locationIcon = R.drawable.location,
    ),
    Mountain(

        BoxImage = R.drawable.images,
        ratingIcon = R.drawable.rating,
        rating = "3.5",
        name = " Beldon Mountain",
        city = " Huhan, ",
        country = "China ",
        locationIcon = R.drawable.location,
    ),
    Mountain(

        BoxImage = R.drawable.icon1,
        ratingIcon = R.drawable.rating,
        rating = "3.5",
        name = " Tororo Mountain",
        city = " Bugema, ",
        country = "Uganda ",
        locationIcon = R.drawable.location,
    ),
    Mountain(

        BoxImage = R.drawable.download5,
        ratingIcon = R.drawable.rating,
        rating = "3.5",
        name = " Easter Mountain",
        city = " Nakuru, ",
        country = "Kenya ",
        locationIcon = R.drawable.location,
    ),
)

