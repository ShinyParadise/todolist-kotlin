package com.example.toDoListKotlin.ui.screens.detailScreen

import android.content.res.Configuration.UI_MODE_NIGHT_NO
import android.content.res.Configuration.UI_MODE_NIGHT_YES
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.toDoListKotlin.dto.ListItem
import com.example.toDoListKotlin.ui.screens.alertDialog.CustomDetailDialog
import com.example.toDoListKotlin.ui.theme.ToDoListAppTheme
import kotlinx.coroutines.launch


@Composable
fun DetailScreen(viewModel: DetailViewModel) {
    val listItems by viewModel.listItems.collectAsState(initial = emptyList())
    val dialogDescription by viewModel.savedDescription.collectAsState()

    DetailScreenContent(
        listItems = listItems,
        dialogDescription = dialogDescription,
        onListItemClick = viewModel::changeItemState,
        addListItem = viewModel::addListItem,
        onChangeDescription = viewModel::setSavedDescription
    )
}

@Composable
private fun DetailScreenContent(
    listItems: List<ListItem>,
    dialogDescription: String,
    onListItemClick: suspend (ListItem) -> Unit,
    addListItem: suspend () -> Unit,
    onChangeDescription: (String) -> Unit
) {
    val coroutineScope = rememberCoroutineScope()
    var openDialog by remember { mutableStateOf(false) }

    Scaffold(
        backgroundColor = MaterialTheme.colors.primary,
        content = { padding ->
            ListItems(
                listItems = listItems,
                modifier = Modifier.padding(padding),
                onListItemClick = {
                    coroutineScope.launch { onListItemClick(it) }
                }
            )

            if (openDialog) {
                CustomDetailDialog(
                    dialogDescription = dialogDescription,
                    onChangeDescription = onChangeDescription,
                    onPositiveClick = {
                        openDialog = false
                        coroutineScope.launch { addListItem() }
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
private fun ListItems(
    listItems: List<ListItem>,
    modifier: Modifier = Modifier,
    onListItemClick: (ListItem) -> Unit
) {
    Surface(
        color = MaterialTheme.colors.primary,
        modifier = modifier
    ) {
        LazyColumn {
            items(items = listItems) {
                ListItem(it, onListItemClick)
            }
        }
    }
}

@Composable
private fun ListItem(
    listItem: ListItem,
    onListItemClick: (ListItem) -> Unit
) {
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
                onCheckedChange = {
                    onListItemClick(listItem)
                    checkedState = it
                }
            )
            Text(
                text = listItem.description,
                fontSize = 24.sp,
                modifier = Modifier.padding(top = 6.dp)
            )
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
private fun Items_Preview_Dark() {
    ToDoListAppTheme {
        DetailScreenContent(
            listItems = listOf(
                ListItem("Test"),
                ListItem("aaaaaaa"),
                ListItem("Life is good")
            ),
            dialogDescription = "",
            onListItemClick = {},
            addListItem = {},
            onChangeDescription = {}
        )
    }
}

@Preview(
    showBackground = true,
    widthDp = 320,
    uiMode = UI_MODE_NIGHT_NO,
    heightDp = 300
)
@Composable
private fun Items_Preview_Light() {
    ToDoListAppTheme {
        DetailScreenContent(
            listItems = listOf(
                ListItem("Test"),
                ListItem("aaaaaaa"),
                ListItem("Life is good")
            ),
            dialogDescription = "",
            onListItemClick = {},
            addListItem = {},
            onChangeDescription = {}
        )
    }
}
