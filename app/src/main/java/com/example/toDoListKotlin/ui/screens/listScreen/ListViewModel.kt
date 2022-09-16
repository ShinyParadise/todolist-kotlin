package com.example.toDoListKotlin.ui.screens.listScreen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.toDoListKotlin.dto.ToDoList
import com.example.toDoListKotlin.repositories.ListRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ListViewModel @Inject constructor (private val listRepository: ListRepository): ViewModel() {
    private val _savedName = MutableStateFlow("")
    val savedName = _savedName.asStateFlow()

    private val _savedDescription = MutableStateFlow("")
    val savedDescription = _savedDescription.asStateFlow()

    private var toDoLists: ArrayList<ToDoList> = ArrayList()
    private var refreshIntervalMs: Long = 1000

    init { viewModelScope.launch { toDoLists = ArrayList(listRepository.loadAll()) } }

    val listFlow: Flow<ArrayList<ToDoList>> = flow {
        toDoLists = ArrayList(listRepository.loadAll())
        emit(toDoLists)
        delay(refreshIntervalMs)
    }

    suspend fun addListFromDialog() {
        if (savedName.value.isNotBlank())
            listRepository.add(ToDoList(savedName.value, savedDescription.value))
    }

    fun setSavedName(name: String) {
        _savedName.value = name
    }

    fun setSavedDescription(description: String) {
        _savedDescription.value = description
    }
}
