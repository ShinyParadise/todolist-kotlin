package com.example.toDoListKotlin.ui.screens.alertDialog

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

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