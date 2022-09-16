package com.example.toDoListKotlin.ui.screens.alertDialog

import android.content.res.Configuration.UI_MODE_NIGHT_NO
import android.content.res.Configuration.UI_MODE_NIGHT_YES
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.material.TextFieldDefaults
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.toDoListKotlin.ui.theme.ToDoListAppTheme
import kotlinx.coroutines.flow.StateFlow


@Composable
fun InputField(
    label: String,
    storedValue: StateFlow<String>,
    onValueChanged: (String) -> Unit
) {
    val text by storedValue.collectAsState()

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
        onValueChange = onValueChanged,
        label = { Text(label) },
        singleLine = true,
        modifier = Modifier.padding(8.dp)
    )
}

@Composable
fun InputFieldImpl(label: String) {
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

@Preview(uiMode = UI_MODE_NIGHT_YES, showBackground = true)
@Composable
private fun InputField_Preview_Dark() {
    ToDoListAppTheme {
        InputFieldImpl(label = "Example")
    }
}

@Preview(uiMode = UI_MODE_NIGHT_NO, showBackground = true)
@Composable
private fun InputField_Preview_Light() {
    ToDoListAppTheme {
        InputFieldImpl(label = "Example")
    }
}
