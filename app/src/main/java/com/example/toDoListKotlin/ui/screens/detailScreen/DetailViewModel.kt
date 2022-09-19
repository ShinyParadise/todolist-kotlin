package com.example.toDoListKotlin.ui.screens.detailScreen

import androidx.lifecycle.ViewModel
import com.example.toDoListKotlin.dto.ListItem
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.*
import javax.inject.Inject

@HiltViewModel
class DetailViewModel @Inject constructor () : ViewModel() {
    private val _savedDescription = MutableStateFlow("")
    val savedDescription = _savedDescription.asStateFlow()

    private val _savedItemState = MutableStateFlow(false)
    val savedItemState = _savedItemState.asStateFlow()

    private val _listItems: MutableStateFlow<List<ListItem>> = MutableStateFlow(emptyList())
    val listItems: StateFlow<List<ListItem>> = _listItems.asStateFlow()

    fun setSavedDescription(description: String) {
        _savedDescription.value = description
    }

    fun changeSavedItemState() {
        _savedItemState.value = !_savedItemState.value
    }
}
