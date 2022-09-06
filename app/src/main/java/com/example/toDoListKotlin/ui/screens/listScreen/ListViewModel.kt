package com.example.toDoListKotlin.ui.screens.listScreen

import androidx.lifecycle.ViewModel
import com.example.toDoListKotlin.dto.ToDoList
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class ListViewModel: ViewModel() {
    private val toDoLists: ArrayList<ToDoList> = ArrayList()

    val listFlow: Flow<ArrayList<ToDoList>> = flow {
            repeat(10) {
                toDoLists.add(generateNewList())
                
                emit(toDoLists)
                delay(1000)
            }
        }
    }

    private fun generateNewList(): ToDoList {
        val alphabet: List<Char> = ('a'..'z') + ('A'..'Z') + ('0'..'9')

        val randomName: String = List(20) { alphabet.random() }.joinToString("")
        val randomDescription: String = List(20) { alphabet.random() }.joinToString("")

        return ToDoList(randomName, randomDescription)
    }
}
