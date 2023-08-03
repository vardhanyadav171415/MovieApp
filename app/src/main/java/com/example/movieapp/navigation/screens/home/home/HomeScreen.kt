package com.example.movieapp.navigation.screens.home

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBox
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.movieapp.Movie
import com.example.movieapp.getMovies
import com.example.movieapp.navigation.MovieScreens
import com.example.movieapp.widgets.MovieRow

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun HomeScreen(navController: NavController){
    Scaffold(topBar = {
        TopAppBar(backgroundColor = Color.Transparent, modifier = Modifier.background(shape = RoundedCornerShape(bottomStart = 8.dp, bottomEnd = 8.dp), color = Color.Transparent).border(width = 0.5.dp,color=Color.Cyan, shape = RoundedCornerShape(bottomStart = 8.dp, bottomEnd = 8.dp)),
            elevation = 0.dp) {
            Text(text="Movies", style = MaterialTheme.typography.body1)
        }
    },) {
        MainContent(navController=navController)
    }
}
@Composable
fun MainContent(navController: NavController,movieList:List<Movie> = getMovies()){
    Column(modifier= Modifier.padding(12.dp)) {
        LazyColumn{
            items(items=movieList){
                MovieRow(movie = it){movie->
                   navController.navigate(route=MovieScreens.DetailsScreen.name +"/$movie")
                }
            }
        }
    }

}
