package com.example.toDoListKotlin.ui.screens.alertDialog

import android.content.res.Configuration
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.toDoListKotlin.R
import com.example.toDoListKotlin.ui.screens.listScreen.ListViewModel
import com.example.toDoListKotlin.ui.theme.ToDoListAppTheme


@Composable
fun CustomListDialog(
    viewModel: ListViewModel,
    onPositiveClick: () -> Unit,
    onNegativeClick: () -> Unit
) {
    val storedName by viewModel.savedName.collectAsState()
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
                    text = stringResource(R.string.add_list_title),
                    fontSize = 20.sp,
                    style = MaterialTheme.typography.h6,
                    modifier = Modifier.padding(8.dp)
                )
                InputField(
                    label = "Name",
                    storedValue = storedName,
                    viewModel::setSavedName
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
private fun CustomListDialogImpl(
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
                    text = stringResource(R.string.add_list_title),
                    fontSize = 20.sp,
                    style = MaterialTheme.typography.h6,
                    modifier = Modifier.padding(8.dp)
                )
                InputField(label = "Name", storedValue = "") {}
                InputField(label = "Description", storedValue = "") {}
            }
        }
    )
}

@Preview(showBackground = true)
@Composable
private fun Dialog_Preview_Light() {
    ToDoListAppTheme {
        CustomListDialogImpl(
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
            onPositiveClick = {},
            onNegativeClick = {}
        )
    }
}
