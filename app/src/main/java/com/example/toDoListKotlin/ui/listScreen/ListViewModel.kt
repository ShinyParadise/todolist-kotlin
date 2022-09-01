package com.example.toDoListKotlin.ui.listScreen

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.toDoListKotlin.dto.ToDoList

class ListViewModel: ViewModel() {
    private val _toDoLists: MutableLiveData<ArrayList<ToDoList>> = MutableLiveData(ArrayList())
    val toDoLists: LiveData<ArrayList<ToDoList>> = _toDoLists

    fun insertNewList() {
        val alphabet: List<Char> = ('a'..'z') + ('A'..'Z') + ('0'..'9')

        val randomName: String = List(20) { alphabet.random() }.joinToString("")
        val randomDescription: String = List(20) { alphabet.random() }.joinToString("")

        val currentList: ArrayList<ToDoList>? = toDoLists.value
        currentList?.add(ToDoList(randomName, randomDescription))

        _toDoLists.postValue(currentList)
    }
}
