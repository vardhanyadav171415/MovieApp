package com.example.movieapp.navigation.screens.home.details

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import coil.compose.rememberImagePainter
import com.example.movieapp.Movie
import com.example.movieapp.getMovies
import com.example.movieapp.navigation.screens.home.MainContent
import com.example.movieapp.widgets.MovieRow

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun DetailsScreen(navController: NavController,movieId: String?) {
   val movieList = getMovies().filter { movie->
      movie.id==movieId
    }
    Scaffold(
        topBar = {
            TopAppBar(
                backgroundColor = Color.Transparent, elevation = 0.dp,
            ) {
                Row(horizontalArrangement = Arrangement.Start) {
                    Icon(imageVector = Icons.Default.ArrowBack, contentDescription ="Arrow Back",
                    modifier = Modifier.clickable {
                        navController.popBackStack()
                    })
                    Spacer(modifier = Modifier.width(200.dp))
                    Text(text = "Movies")
                }
            }
        },
    ) {
        Surface(modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight()) {
            Column(horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.Top) {
                MovieRow(movie=movieList.first())
               
                Spacer(modifier = Modifier.height(8.dp))
                Divider()
                Text(text = "Movie Images")
                HorizontalScrollableImageView(movieList)
                 
            }
        }
    }


}

@Composable
private fun HorizontalScrollableImageView(movieList: List<Movie>) {
    LazyRow {
        items(movieList[0].images) { images ->
            Card(
                modifier = Modifier
                    .padding(12.dp)

                    .size(240.dp)
                    .border(
                        width = 0.5.dp,
                        color = Color.Cyan,
                        shape = RoundedCornerShape(corner = CornerSize(6.dp))

                    ), elevation = 5.dp, shape = RoundedCornerShape(corner = CornerSize(6.dp))
            ) {
                Image(
                    painter = rememberImagePainter(data = images),
                    contentDescription = "Movie Poster"
                )


            }

        }
    }
}