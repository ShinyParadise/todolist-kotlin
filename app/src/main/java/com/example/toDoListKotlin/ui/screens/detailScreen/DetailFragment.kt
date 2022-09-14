package com.example.toDoListKotlin.ui.screens.detailScreen

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.platform.ComposeView
import androidx.fragment.app.Fragment
import com.example.toDoListKotlin.dto.ListItem
import com.example.toDoListKotlin.ui.screens.alertDialog.CustomDialog
import com.example.toDoListKotlin.ui.theme.ToDoListAppTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DetailFragment : Fragment() {
    private val details: List<ListItem> = listOf(
        ListItem("Test", false),
        ListItem("aaaaaaa", true),
        ListItem("Life is good", true)
    )

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return ComposeView(requireContext()).apply {
            setContent {
                var openDialog by remember { mutableStateOf(false) }

                ToDoListAppTheme {
                    DetailScreen(listItems = details) {
                        openDialog = true
                    }

                    if (openDialog) {
                        CustomDialog(
                            inputFields = arrayOf("Description"),
                            title = "Add list item",
                            onPositiveClick = { openDialog = false },
                            onNegativeClick = { openDialog = false }
                        )
                    }
                }
            }
        }
    }
}
