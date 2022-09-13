package com.example.toDoListKotlin.ui.screens.detailScreen

import android.content.res.Configuration
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.toDoListKotlin.dto.ListItem
import com.example.toDoListKotlin.ui.theme.ToDoListAppTheme


@Composable
fun ListItemsImpl(listItems: List<ListItem>) {
    Surface(color = MaterialTheme.colors.primary) {
        LazyColumn {
            items(items = listItems) {
                ListItem(it)
            }
        }
    }
}

@Composable
private fun ListItem(listItem: ListItem) {
    var checkedState by remember { mutableStateOf(listItem.state) }
    
    Surface(
        color = MaterialTheme.colors.primary,
        contentColor = MaterialTheme.colors.onPrimary,
        modifier = Modifier.fillMaxWidth()
    ) {
        Row {
            Checkbox(
                colors = CheckboxDefaults.colors(
                    checkedColor = MaterialTheme.colors.onPrimary,
                    uncheckedColor = MaterialTheme.colors.onPrimary,
                    checkmarkColor = MaterialTheme.colors.primary
                ),
                checked = checkedState,
                onCheckedChange = { checkedState = it }
            )
            Text(
                text = listItem.description,
                fontSize = 24.sp,
                modifier = Modifier.padding(top = 6.dp)
            )
        }
    }
}

@Preview(showBackground = true, widthDp = 320, uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
private fun Items_Preview_Dark() {
    ToDoListAppTheme {
        ListItemsImpl(listItems = listOf(
            ListItem("Test", false),
            ListItem("aaaaaaa", true),
            ListItem("Life is good", true)
        ))
    }
}

@Preview(showBackground = true, widthDp = 320, uiMode = Configuration.UI_MODE_NIGHT_NO)
@Composable
private fun Items_Preview_Light() {
    ToDoListAppTheme {
        ListItemsImpl(listItems = listOf(ListItem("Test", false),
            ListItem("aaaaaaa", true),
            ListItem("Life is good", true)
        ))
    }
}
