package com.example.toDoListKotlin.ui.screens.listScreen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.foundation.lazy.items
import androidx.compose.material.MaterialTheme
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
    Column(modifier = Modifier.padding(vertical = 4.dp)) {
        Text(
            text = list.header,
            style = MaterialTheme.typography.h6
        )
        Text(text = list.description)
    }
}

@Preview(showBackground = true)
@Composable
private fun ToDoLists_Preview() {
    ToDoListAppTheme {
        ToDoListsImpl(lists = listOf(
                ToDoList("Header", "Description"),
                ToDoList("Test", "Test")
            )
        )
    }
}
