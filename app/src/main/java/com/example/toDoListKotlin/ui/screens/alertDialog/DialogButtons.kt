package com.example.toDoListKotlin.ui.screens.alertDialog

import android.content.res.Configuration.UI_MODE_NIGHT_YES
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.toDoListKotlin.ui.theme.ToDoListAppTheme

@Composable
fun BackButton(onClick: () -> Unit) {
    Button(
        onClick = onClick,
        modifier = Modifier.fillMaxWidth(0.5f)
    ) {
        Text(text = "Back")
    }
}

@Composable
fun AddButton(onClick: () -> Unit) {
    Button(
        onClick = onClick,
        Modifier.fillMaxWidth(1f)
    ) {
        Text(text = "Add")
    }
}

@Preview
@Composable
private fun Buttons_Preview_Light() {
    ToDoListAppTheme {
        Row {
            BackButton {}
            AddButton {}
        }
    }
}

@Preview(uiMode = UI_MODE_NIGHT_YES)
@Composable
private fun Buttons_Preview_Dark() {
    ToDoListAppTheme {
        Row {
            BackButton {}
            AddButton {}
        }
    }
}
