package com.example.toDoListKotlin.ui.screens.detailScreen

import androidx.lifecycle.ViewModel
import com.example.toDoListKotlin.dto.ListItem
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

@HiltViewModel
class DetailViewModel @Inject constructor () : ViewModel() {
    private val _savedDescription = MutableStateFlow("")
    val savedDescription = _savedDescription.asStateFlow()

    private val listItems: ArrayList<ListItem> = ArrayList()
    private var refreshIntervalMs: Long = 1000

    val itemsFlow: Flow<ArrayList<ListItem>> = flow {
        emit(listItems)
        delay(refreshIntervalMs)
    }

    fun setSavedDescription(description: String) {
        _savedDescription.value = description
    }
}
