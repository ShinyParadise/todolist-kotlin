package com.example.toDoListKotlin.ui.screens.alertDialog

import android.content.res.Configuration
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.toDoListKotlin.ui.theme.ToDoListAppTheme


@Composable
fun CustomDialog(
    vararg inputFields: String,
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
                for (field in inputFields)
                    InputField(label = field)
            }
        }
    )
}

@Composable
private fun InputField(label: String) {
    var text by remember { mutableStateOf("") }

    TextField(
        colors = TextFieldDefaults.textFieldColors(
            textColor = MaterialTheme.colors.onPrimary,
            focusedIndicatorColor = MaterialTheme.colors.onPrimary,
            focusedLabelColor = MaterialTheme.colors.onPrimary,
            unfocusedIndicatorColor = MaterialTheme.colors.onPrimary,
            unfocusedLabelColor = MaterialTheme.colors.onPrimary,
            cursorColor = MaterialTheme.colors.onPrimary
        ),
        value = text,
        onValueChange = { text = it },
        label = { Text(label) },
        singleLine = true,
        modifier = Modifier.padding(8.dp)
    )
}

@Preview(showBackground = true)
@Composable
private fun Dialog_Preview_Light() {
    ToDoListAppTheme {
        CustomDialog(
            inputFields = arrayOf("Name", "Details"),
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
        CustomDialog(
            inputFields = arrayOf("Name", "Details"),
            title = "Add list",
            onPositiveClick = {},
            onNegativeClick = {}
        )
    }
}
