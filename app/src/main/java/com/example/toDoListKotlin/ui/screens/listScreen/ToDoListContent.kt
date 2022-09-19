package com.example.toDoListKotlin.ui.screens.listScreen

import android.content.res.Configuration.UI_MODE_NIGHT_NO
import android.content.res.Configuration.UI_MODE_NIGHT_YES
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.runtime.*
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import com.example.toDoListKotlin.dto.ToDoList
import com.example.toDoListKotlin.ui.screens.alertDialog.CustomListDialog
import com.example.toDoListKotlin.ui.theme.ToDoListAppTheme
import kotlinx.coroutines.launch

@Composable
fun ListsScreen(listViewModel: ListViewModel, onItemClick: (ToDoList) -> Unit) {
    val coroutineScope = rememberCoroutineScope()

    val lists by listViewModel.toDoLists.collectAsState(initial = emptyList())
    var openDialog by remember { mutableStateOf(false) }

    Scaffold(
        backgroundColor = MaterialTheme.colors.primary,
        content = { paddingValues ->
            ToDoLists(lists = lists, Modifier.padding(paddingValues), onItemClick)

            if (openDialog) {
                CustomListDialog(
                    viewModel = listViewModel,
                    title = "Add a list",
                    onPositiveClick = {
                        openDialog = false
                        coroutineScope.launch { listViewModel.addListFromDialog() }
                    },
                    onNegativeClick = { openDialog = false }
                )
            }
        },
        floatingActionButton = {
            FloatingActionButton(
                onClick = { openDialog = true },
                backgroundColor = MaterialTheme.colors.onPrimary,
                contentColor = MaterialTheme.colors.primary
            ) {
                Icon(Icons.Filled.Add, "Add an item")
            }
        }
    )
}

@Composable
private fun ListScreenImpl(
    lists: List<ToDoList>,
    onAddButtonClick: () -> Unit
) {
    Scaffold(
        backgroundColor = MaterialTheme.colors.primary,
        content = { paddingValues ->
            ToDoLists(lists = lists, Modifier.padding(paddingValues)) {}
        },
        floatingActionButton = {
            FloatingActionButton(
                onClick = onAddButtonClick,
                backgroundColor = MaterialTheme.colors.onPrimary,
                contentColor = MaterialTheme.colors.primary
            ) {
                Icon(Icons.Filled.Add, "Add an item")
            }
        }
    )
}

@Composable
fun ToDoLists(
    lists: List<ToDoList>,
    modifier: Modifier = Modifier,
    onItemClick: (ToDoList) -> Unit
) {
    Surface(
        color = MaterialTheme.colors.primary,
        contentColor = MaterialTheme.colors.onPrimary,
        modifier = modifier
    ) {
        LazyColumn {
            items(items = lists) { list ->
                ToDoListItem(list, onItemClick)
            }
        }
    }
}

@Composable
private fun ToDoListItem(list: ToDoList, onItemClick: (ToDoList) -> Unit) {
    Surface(
        color = MaterialTheme.colors.primary,
        contentColor = MaterialTheme.colors.onPrimary,
        modifier = Modifier.fillMaxWidth().clickable { onItemClick(list) }
    ) {
        Column {
            Text(
                text = list.name,
                fontSize = 24.sp,
                style = MaterialTheme.typography.h6,
                modifier = Modifier.padding(top = 4.dp)
            )
            list.description?.let { Text(
                text = it,
                fontSize = 18.sp,
                modifier = Modifier.padding(bottom = 4.dp))
            }
        }
    }
}

@Preview(
    showBackground = true,
    widthDp = 320,
    uiMode = UI_MODE_NIGHT_YES,
    heightDp = 300
)
@Composable
private fun ToDoLists_Preview_Dark() {
    ToDoListAppTheme {
        ListScreenImpl(lists = listOf(
            ToDoList("Header", "Description"),
            ToDoList("Test", "Test")
        )) {}
    }
}

@Preview(
    showBackground = true,
    widthDp = 320,
    uiMode = UI_MODE_NIGHT_NO,
    heightDp = 300
)
@Composable
private fun ToDoLists_Preview_Light() {
    ToDoListAppTheme {
        ListScreenImpl(lists = listOf(
            ToDoList("Header", "Description"),
            ToDoList("Test", "Test")
        )) {}
    }
}
