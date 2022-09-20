package com.example.toDoListKotlin.ui.screens.detailScreen

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.compose.ui.platform.ComposeView
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.toDoListKotlin.dto.ListItem
import com.example.toDoListKotlin.dto.ToDoList
import com.example.toDoListKotlin.ui.theme.ToDoListAppTheme
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class DetailFragment(val toDoList: ToDoList) : Fragment() {
    @Inject
    lateinit var detailViewModelFactory: DetailViewModel.AssistedFactory

    private val viewModel: DetailViewModel by viewModels {
        DetailViewModel.provideFactory(detailViewModelFactory, toDoList)
    }

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View {
        return ComposeView(requireContext()).apply {
            setContent {
                ToDoListAppTheme {
                    DetailScreen(viewModel)
                }
            }
        }
    }
}

