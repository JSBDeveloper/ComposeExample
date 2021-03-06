package com.example.composeexample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.MaterialTheme.typography
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            NewsStory()
        }
    }

    @Composable
    fun ArtistCard(artistName: String, lastSeenOnline: String) {
        Row(verticalAlignment = Alignment.CenterVertically) {
            Column {
                Text(artistName)
                Text(lastSeenOnline)
            }
        }
    }

    @Composable
    fun AlignInRow() {
        Row(
            modifier = Modifier
                .size(150.dp)
                .background(Color.Yellow),
            horizontalArrangement = Arrangement.End,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Box(Modifier.size(50.dp).background(Color.Red))
            Box(Modifier.size(50.dp).background(Color.Blue))
        }
    }

    @Composable
    fun NewsStory() {
        MaterialTheme {
            Column(
                modifier = Modifier.padding(16.dp)
            ) {

                Image(
                    painter = painterResource(R.drawable.ic_launcher_background),
                    contentDescription = null,
                    modifier = Modifier.height(180.dp).fillMaxWidth()
                        .clip(shape = RoundedCornerShape(4.dp)),
                    contentScale = ContentScale.Crop
                )

                Spacer(Modifier.height(16.dp))

                Text("A day wandering through the sandhills " +
                        "in Shark Fin Cove, and a few of the " +
                        "sights I saw",
                    maxLines = 2,
                    overflow = TextOverflow.Ellipsis,
                    style = typography.h6)
                Text("Davenport, California", style = typography.body2)
                Text("December 2018", style = typography.body2)
            }
        }
    }

    @Composable
    fun MessageList() {
        LazyColumn(contentPadding = PaddingValues(horizontal = 16.dp, vertical = 8.dp)) {
            item {
                Text(text = "First item")
            }

            // Add 5 items
            items(5) { index ->
                Text(text = "Item: $index")
            }

            // Add another single item
            item {
                Text(text = "Last item")
            }
        }
    }

    @Preview
    @Composable
    fun DefaultPreview() {
        NewsStory()
    }
}