package com.example.germantest

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.germantest.ui.theme.GermantestTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            GermantestTheme {
                var curPage by remember { mutableStateOf("Main") }

                Header(onPageChange = {newPage -> curPage = newPage})

                when(curPage){
                    "Main" -> MainPage()
                    "Create" -> CreatePage()
                    "Browse" -> BrowsePage()
                }
            }
        }
    }
}

@Composable
fun MainPage(modifier: Modifier = Modifier) {
    Text("Main")
}

@Composable
fun BrowsePage(modifier: Modifier = Modifier) {
    Text("Browse")
}

@Composable
fun CreatePage(modifier: Modifier = Modifier) {
    Text("Create")
}

@Composable
fun Header(
    onPageChange: (String) -> Unit,
) {
    Row {
        IconButton(onClick = { onPageChange("Main") }) {
            Icon(Icons.Default.Home, contentDescription = "Home")
        }
        IconButton(onClick = { onPageChange("Browse") }) {
            Icon(Icons.Default.Search, contentDescription = "Browse")
        }
        IconButton(onClick = { onPageChange("Create") }) {
            Icon(Icons.Default.Add, contentDescription = "Create")
        }
    }
    HorizontalDivider()
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    GermantestTheme {

    }
}