package com.example.germantest.components
import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.material3.*
import androidx.compose.ui.unit.sp
import androidx.compose.ui.text.TextStyle

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun Header(
    onPageChange: (String) -> Unit, onSearchChange: (String) -> Unit,
) {
    var searchValue by remember { mutableStateOf("") }
    Row(
        modifier = Modifier
            .padding(top = 35.dp)
            .fillMaxWidth()
            .height(50.dp)
    ){
        Box(
            modifier = Modifier
                .padding(top = 10.dp, start = 5.dp)
        ) {
            BasicTextField(
                value = searchValue,
                onValueChange = {searchValue = it},
                textStyle = TextStyle(fontSize = 16.sp, lineHeight = 16.sp, color = Color.Black),
                modifier = Modifier
                    .height(30.dp)
                    .width(250.dp)
                    .border(
                        width = 2.dp,
                        color = if (searchValue == "") Color.Gray else Color.Blue
                    )
                    .padding(6.dp),

                singleLine = true
            )
        }
        Row(
            horizontalArrangement = Arrangement.End,
        )
        {
            IconButton(onClick = { onPageChange("Browse"); onSearchChange(searchValue) }) {
                Icon(Icons.Default.Search, contentDescription = "Browse")
            }
            IconButton(onClick = { onPageChange("Main") }) {
                Icon(Icons.Default.Home, contentDescription = "Home")
            }
            IconButton(onClick = { onPageChange("Create") }) {
                Icon(Icons.Default.Add, contentDescription = "Create")
            }
        }
    }
    HorizontalDivider()
}