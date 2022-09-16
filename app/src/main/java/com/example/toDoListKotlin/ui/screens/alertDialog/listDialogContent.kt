package com.example.toDoListKotlin.ui.screens.alertDialog

import android.content.res.Configuration
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.toDoListKotlin.ui.screens.listScreen.ListViewModel
import com.example.toDoListKotlin.ui.theme.ToDoListAppTheme
import kotlinx.coroutines.flow.StateFlow


@Composable
fun CustomListDialog(
    viewModel: ListViewModel,
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
                Button(
                    onClick = onNegativeClick,
                    modifier = Modifier.fillMaxWidth(0.5f)
                ) {
                    Text(text = "Back")
                }

                Button(
                    onClick = onPositiveClick,
                    Modifier.fillMaxWidth(1f)
                ) {
                    Text(text = "Add")
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
                    label = "Name",
                    storedValue = viewModel.savedName,
                    viewModel::setSavedName
                )
                InputField(
                    label = "Description",
                    storedValue = viewModel.savedDescription,
                    viewModel::setSavedDescription
                )
            }
        }
    )
}

@Composable
fun CustomListDialogImpl(
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
                Button(
                    onClick = onNegativeClick,
                    modifier = Modifier.fillMaxWidth(0.5f)
                ) {
                    Text(text = "Back")
                }

                Button(
                    onClick = onPositiveClick,
                    Modifier.fillMaxWidth(1f)
                ) {
                    Text(text = "Add")
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
                InputFieldImpl(label = "Name")
                InputFieldImpl(label = "Description")
            }
        }
    )
}

@Preview(showBackground = true)
@Composable
private fun Dialog_Preview_Light() {
    ToDoListAppTheme {
        CustomListDialogImpl(
            title = "Add list",
            onPositiveClick = {},
            onNegativeClick = {}
        )
    }
}

@Preview(showBackground = true, uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
private fun Dialog_Preview_Dark() {
    ToDoListAppTheme {
        CustomListDialogImpl(
            title = "Add list",
            onPositiveClick = {},
            onNegativeClick = {}
        )
    }
}
