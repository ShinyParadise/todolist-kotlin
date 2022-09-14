package com.example.toDoListKotlin.ui.screens.listScreen

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
import androidx.fragment.app.viewModels
import com.example.toDoListKotlin.ui.screens.alertDialog.CustomDialog
import com.example.toDoListKotlin.ui.theme.ToDoListAppTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ListsFragment : Fragment() {
    private val viewModel: ListViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return ComposeView(requireContext()).apply {
            setContent {
                var openDialog by remember { mutableStateOf(false) }

                ToDoListAppTheme {
                    ListsScreen(listViewModel = viewModel) {
                        openDialog = true
                    }

                    if (openDialog) {
                        CustomDialog(
                            inputFields = arrayOf("Name", "Description"),
                            title = "Add a list",
                            onPositiveClick = { openDialog = false },
                            onNegativeClick = { openDialog = false }
                        )
                    }
                }
            }
        }
    }
}
