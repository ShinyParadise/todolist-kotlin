package com.example.toDoListKotlin.ui.screens.listScreen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.toDoListKotlin.dto.ToDoList
import com.example.toDoListKotlin.repositories.ListRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ListViewModel @Inject constructor (private val listRepository: ListRepository): ViewModel() {
    private val _savedName = MutableStateFlow("")
    val savedName = _savedName.asStateFlow()

    private val _savedDescription = MutableStateFlow("")
    val savedDescription = _savedDescription.asStateFlow()

    private val _toDoLists: MutableStateFlow<List<ToDoList>> = MutableStateFlow(emptyList())
    val toDoLists: StateFlow<List<ToDoList>> = _toDoLists.asStateFlow()

    init { viewModelScope.launch { _toDoLists.value = listRepository.loadAll() } }

    suspend fun addListFromDialog() {
        if (savedName.value.isNotBlank()) {
            listRepository.add(ToDoList(savedName.value, savedDescription.value))
            _toDoLists.value = listRepository.loadAll()
        }
    }

    fun setSavedName(name: String) {
        _savedName.value = name
    }

    fun setSavedDescription(description: String) {
        _savedDescription.value = description
    }
}
