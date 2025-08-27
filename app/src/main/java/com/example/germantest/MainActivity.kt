package com.example.germantest

import android.os.Build
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.tooling.preview.Preview
import com.example.germantest.ui.theme.GermantestTheme
import com.example.germantest.components.Header
import com.example.germantest.pages.BrowsePage
import com.example.germantest.pages.CreatePage
import com.example.germantest.pages.MainPage

class MainActivity : ComponentActivity() {
    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            GermantestTheme {
                var curPage by remember { mutableStateOf("Main") }
                var curSearch by remember {mutableStateOf("")}
                Column {
                    Header(
                        onPageChange = { newPage ->
                            curPage = newPage
                        },
                        onSearchChange = {newSearch -> curSearch = newSearch}
                    )

                    when(curPage){
                        "Main" -> MainPage()
                        "Create" -> CreatePage()
                        "Browse" -> BrowsePage(searchValue = curSearch)
                    }
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    GermantestTheme {

    }
}