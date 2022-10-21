package com.rabarka.day

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.rabarka.day.model.Dog
import com.rabarka.day.ui.theme.DayTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            DayTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    DogList()
                }
            }
        }
    }
}

@Composable
fun DogList() {
    Scaffold(topBar = { DogTopBar() }) {
        LazyColumn() {
            items(DataSource.dogs) {
                DogCard(dog = it)
            }
        }
    }
}

@Composable
fun DogTopBar() {
    Box(modifier = Modifier
        .fillMaxWidth()
        .padding(8.dp), contentAlignment = Alignment.Center) {
        Text(text = stringResource(id = R.string.app_name), style = MaterialTheme.typography.h1)
    }
}

@Composable
fun DogCard(dog: Dog, modifier: Modifier = Modifier) {
    Card(
        elevation = 4.dp, modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
    ) {
        Column(modifier.padding(16.dp)) {
            Text(
                text = stringResource(id = dog.day),
                modifier = Modifier.padding(bottom = 8.dp),
                style = MaterialTheme.typography.body2
            )
            Text(
                text = stringResource(id = dog.breed),
                modifier = Modifier.padding(bottom = 8.dp),
                style = MaterialTheme.typography.h3
            )
            ImageShower(image = dog.image, breed = dog.breed)
            Text(text = stringResource(id = dog.summary), style = MaterialTheme.typography.body1)
        }
    }
}

@Composable
fun ImageShower(image: Int, breed: Int) {
    Image(
        painterResource(id = image),
        contentDescription = stringResource(id = breed),
        contentScale = ContentScale.FillWidth,
        modifier = Modifier
            .fillMaxWidth()
            .padding(bottom = 8.dp).clip(RoundedCornerShape(16.dp))
    )
}

@Preview
@Composable
fun FinalPreview() {
    DogTopBar()
//    DogCard(dog = Dog(R.string.day_1, R.string.breed_1, R.drawable.img_1, R.string.summary_1))
}

