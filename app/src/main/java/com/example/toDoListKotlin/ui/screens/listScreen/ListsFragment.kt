package com.example.toDoListKotlin.ui.screens.listScreen

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.ui.platform.ComposeView
import androidx.fragment.app.Fragment
import com.example.toDoListKotlin.ui.theme.ToDoListAppTheme

class ListsFragment : Fragment() {
    private val listViewModel: ListViewModel = ListViewModel()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return ComposeView(requireContext()).apply {
            setContent {
                ToDoListAppTheme {
                    ListsLiveDataComponent(listsLiveData = listViewModel.toDoLists)
                }
            }
        }
    }
}
