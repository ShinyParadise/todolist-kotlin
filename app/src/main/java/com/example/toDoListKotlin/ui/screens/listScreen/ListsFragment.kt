package com.example.toDoListKotlin.ui.screens.listScreen

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.ui.platform.ComposeView
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.toDoListKotlin.R
import com.example.toDoListKotlin.ui.screens.detailScreen.DetailFragment
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
                    ListsScreen(
                        listViewModel = viewModel,
                        onItemClick = {
                            parentFragmentManager.beginTransaction()
                                .replace(R.id.fragment_container_view, DetailFragment(it))
                                .addToBackStack(null)
                                .commit()
                        }
                    )
                }
            }
        }
    }
}
