package com.example.toDoListKotlin.ui.screens.listScreen

import androidx.lifecycle.ViewModel
import com.example.toDoListKotlin.dto.ToDoList
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class ListViewModel: ViewModel() {
    private val toDoLists: ArrayList<ToDoList> = ArrayList()

    init {
        repeat(10) {
            toDoLists.add(generateNewList())
        }
    }

    val listFlow: Flow<ArrayList<ToDoList>> = flow {
        while(true) {
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
