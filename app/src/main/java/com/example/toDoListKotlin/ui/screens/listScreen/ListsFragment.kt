package com.example.toDoListKotlin.ui.screens.listScreen

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.compose.ui.platform.ComposeView
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
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
                ToDoListAppTheme {
                    DetailScreen(listViewModel = viewModel) {
                        Toast.makeText(requireContext(), "Clicked", Toast.LENGTH_SHORT).show()
                    }
                }
            }
        }
    }
}
