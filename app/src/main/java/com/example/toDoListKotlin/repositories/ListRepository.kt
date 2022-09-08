package com.example.toDoListKotlin.repositories

import com.example.toDoListKotlin.dto.ToDoList

interface ListRepository {
    suspend fun loadAll(): List<ToDoList>
    suspend fun add(list: ToDoList): ToDoList
}
