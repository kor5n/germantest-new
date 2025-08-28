package com.example.germantest.pages
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import com.example.germantest.model.TestItem
import com.example.germantest.network.RetrofitInstance



@Composable
fun BrowsePage(modifier: Modifier = Modifier, searchValue: String) {
    val api = RetrofitInstance.create("http://10.38.33.91:5000")

    var posts: List<TestItem> by remember { mutableStateOf<List<TestItem>>(emptyList()) }

    LaunchedEffect(searchValue) {
        try {
            val response = api.getPosts("/b/browse/$searchValue")
            posts = response.tests[0]
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }

    LazyColumn(modifier = modifier.fillMaxSize()) {
        if (posts.isNotEmpty()) {
            items(posts) { post ->
                Text(text = post.title)
            }
        } else {
            item {
                Text(text = "Search $searchValue")
            }
        }
    }


}