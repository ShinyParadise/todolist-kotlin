package com.example.toDoListKotlin.ui.screens.listScreen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.toDoListKotlin.dto.ToDoList
import com.example.toDoListKotlin.repositories.ListRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ListViewModel @Inject constructor (private val listRepository: ListRepository): ViewModel() {
    private var toDoLists: ArrayList<ToDoList> = ArrayList()

    init {
        viewModelScope.launch { toDoLists = ArrayList(listRepository.loadAll()) }
    }

    val listFlow: Flow<ArrayList<ToDoList>> = flow {
        repeat(10) {
            listRepository.add(generateNewList())

            toDoLists = ArrayList(listRepository.loadAll())
            emit(toDoLists)

            delay(1000)
        }
    }

    private fun generateNewList(): ToDoList {
        val alphabet: List<Char> = ('a'..'z') + ('A'..'Z') + ('0'..'9')

        val randomName: String = List(20) { alphabet.random() }.joinToString("")
        val randomDescription: String = List(20) { alphabet.random() }.joinToString("")

        return ToDoList(randomName, randomDescription)
    }
}
