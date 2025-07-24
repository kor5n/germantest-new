package com.example.germantest.pages
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier


@Composable
fun BrowsePage(modifier: Modifier = Modifier, searchValue: (String)) {
    Text("Browse $searchValue")
}