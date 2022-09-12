package com.example.toDoListKotlin.ui.screens.listScreen

import android.content.res.Configuration.UI_MODE_NIGHT_NO
import android.content.res.Configuration.UI_MODE_NIGHT_YES
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.foundation.lazy.items
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.tooling.preview.Preview
import com.example.toDoListKotlin.dto.ToDoList
import com.example.toDoListKotlin.ui.theme.ToDoListAppTheme


@Composable
fun ToDoLists(listViewModel: ListViewModel) {
    val lists by listViewModel.listFlow.collectAsState(initial = emptyList())

    LazyColumn(modifier = Modifier.padding(vertical = 4.dp)) {
        items(items = lists) { list ->
            ToDoListItem(list)
        }
    }
}

@Composable
private fun ToDoListsImpl(lists: List<ToDoList>) {
    LazyColumn(modifier = Modifier.padding(vertical = 4.dp)) {
       items(items = lists) {
           list -> ToDoListItem(list)
       }
    }
}

@Composable
private fun ToDoListItem(list: ToDoList) {
    Surface(
        color = MaterialTheme.colors.primary,
        contentColor = MaterialTheme.colors.onPrimary,
        modifier = Modifier.fillMaxWidth()
    ) {
        Column(modifier = Modifier.padding(vertical = 4.dp)) {
            Text(
                text = list.name,
                style = MaterialTheme.typography.h6
            )
            list.description?.let { Text(text = it) }
        }
    }
}

@Preview(showBackground = true, widthDp = 320, uiMode = UI_MODE_NIGHT_YES)
@Composable
private fun ToDoLists_Preview_Dark() {
    ToDoListAppTheme {
        ToDoListsImpl(lists = listOf(
                ToDoList("Header", "Description"),
                ToDoList("Test", "Test")
            )
        )
    }
}

@Preview(showBackground = true, widthDp = 320, uiMode = UI_MODE_NIGHT_NO)
@Composable
private fun ToDoLists_Preview_Light() {
    ToDoListAppTheme {
        ToDoListsImpl(lists = listOf(
            ToDoList("Header", "Description"),
            ToDoList("Test", "Test")
        )
        )
    }
}
