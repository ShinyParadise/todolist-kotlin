package com.example.toDoListKotlin.ui.screens.alertDialog

import android.content.res.Configuration
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.toDoListKotlin.ui.screens.detailScreen.DetailViewModel
import com.example.toDoListKotlin.ui.theme.ToDoListAppTheme


@Composable
fun CustomDetailDialog(
    viewModel: DetailViewModel,
    title: String,
    onPositiveClick: () -> Unit,
    onNegativeClick: () -> Unit
) {
    val storedDescription by viewModel.savedDescription.collectAsState()

    AlertDialog(
        onDismissRequest = onNegativeClick,
        contentColor = MaterialTheme.colors.onBackground,
        backgroundColor = MaterialTheme.colors.background,
        buttons = {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp)
            ) {
                BackButton {
                    onNegativeClick()
                }
                AddButton {
                    onPositiveClick()
                }
            }
        },
        text = {
            Column(Modifier.padding(vertical = 8.dp)) {
                Text(
                    text = title,
                    fontSize = 20.sp,
                    style = MaterialTheme.typography.h6,
                    modifier = Modifier.padding(8.dp)
                )
                InputField(
                    label = "Description",
                    storedValue = storedDescription,
                    viewModel::setSavedDescription
                )
            }
        }
    )
}

@Composable
private fun CustomDetailDialogImpl(
    title: String,
    onPositiveClick: () -> Unit,
    onNegativeClick: () -> Unit
) {
    AlertDialog(
        onDismissRequest = onNegativeClick,
        contentColor = MaterialTheme.colors.onBackground,
        backgroundColor = MaterialTheme.colors.background,
        buttons = {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp)
            ) {
                BackButton {
                    onNegativeClick()
                }
                AddButton {
                    onPositiveClick()
                }
            }
        },
        text = {
            Column(Modifier.padding(vertical = 8.dp)) {
                Text(
                    text = title,
                    fontSize = 20.sp,
                    style = MaterialTheme.typography.h6,
                    modifier = Modifier.padding(8.dp)
                )
                InputFieldImpl(label = "Description")
            }
        }
    )
}

@Preview(showBackground = true)
@Composable
private fun Dialog_Preview_Light() {
    ToDoListAppTheme {
        CustomDetailDialogImpl(
            title = "Add list item",
            onPositiveClick = {},
            onNegativeClick = {}
        )
    }
}

@Preview(showBackground = true, uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
private fun Dialog_Preview_Dark() {
    ToDoListAppTheme {
        CustomDetailDialogImpl(
            title = "Add list item",
            onPositiveClick = {},
            onNegativeClick = {}
        )
    }
}
