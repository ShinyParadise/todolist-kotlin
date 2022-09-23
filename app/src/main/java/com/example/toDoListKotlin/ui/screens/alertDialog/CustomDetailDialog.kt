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
import com.example.toDoListKotlin.ui.screens.detailScreen.DetailViewModel
import com.example.toDoListKotlin.ui.theme.ToDoListAppTheme


@Composable
fun CustomDetailDialog(
    dialogDescription: String,
    onPositiveClick: () -> Unit,
    onNegativeClick: () -> Unit,
    onChangeDescription: (String) -> Unit
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
                    text = stringResource(R.string.add_list_item_title),
                    fontSize = 20.sp,
                    style = MaterialTheme.typography.h6,
                    modifier = Modifier.padding(8.dp)
                )
                InputField(
                    label = "Description",
                    storedValue = dialogDescription,
                    onChangeDescription
                )
            }
        }
    )
}

@Preview(showBackground = true)
@Composable
private fun Dialog_Preview_Light() {
    ToDoListAppTheme {
        CustomDetailDialog(
            dialogDescription = "",
            onPositiveClick = {},
            onNegativeClick = {},
            onChangeDescription = {}
        )
    }
}

@Preview(showBackground = true, uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
private fun Dialog_Preview_Dark() {
    ToDoListAppTheme {
        CustomDetailDialog(
            dialogDescription = "",
            onPositiveClick = {},
            onNegativeClick = {},
            onChangeDescription = {}
        )
    }
}
