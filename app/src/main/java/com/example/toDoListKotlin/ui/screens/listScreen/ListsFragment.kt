package com.example.toDoListKotlin.ui.screens.listScreen

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.ui.platform.ComposeView
import androidx.fragment.app.Fragment
import com.example.toDoListKotlin.db.AppDatabase
import com.example.toDoListKotlin.repositories.ListRepositoryImpl
import com.example.toDoListKotlin.ui.ToDoListApp
import com.example.toDoListKotlin.ui.theme.ToDoListAppTheme

class ListsFragment : Fragment() {
    private val viewModel: ListViewModel

    init {
        val appContext = ToDoListApp.instance.applicationContext
        val dbInstance = AppDatabase.getInstance(appContext)
        viewModel = ListViewModel(ListRepositoryImpl(dbInstance.toDoListDAO()))
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return ComposeView(requireContext()).apply {
            setContent {
                ToDoListAppTheme {
                    ToDoLists(listViewModel = viewModel)
                }
            }
        }
    }
}
