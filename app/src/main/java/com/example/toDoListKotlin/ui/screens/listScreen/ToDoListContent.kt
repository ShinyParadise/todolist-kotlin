package com.example.toDoListKotlin.ui.screens.listScreen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.foundation.lazy.items
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.getValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.LiveData
import com.example.toDoListKotlin.dto.ToDoList
import com.example.toDoListKotlin.ui.theme.ToDoListAppTheme


@Preview(showBackground = true)
@Composable
private fun ExampleList() {
    ToDoListAppTheme {
        ToDoLists(lists = listOf(
                ToDoList("Header", "Description"),
                ToDoList("Test", "Test")
            )
        )
    }
}

@Composable
fun ToDoLists(lists: List<ToDoList>) {
    LazyColumn(modifier = Modifier.padding(vertical = 4.dp)) {
        items(items = lists) {
            list -> DisplayToDoList(list)
        }
    }
}

@Composable
fun DisplayToDoList(list: ToDoList) {
    Column(modifier = Modifier.padding(vertical = 4.dp)) {
        Text(
            text = list.header,
            style = MaterialTheme.typography.h6
        )
        Text(text = list.description)
    }
}

@Composable
fun ListsLiveDataComponent(listsLiveData: LiveData<ArrayList<ToDoList>>) {
    val toDoLists by listsLiveData.observeAsState(initial = emptyList())

    ToDoLists(lists = toDoLists)
}
