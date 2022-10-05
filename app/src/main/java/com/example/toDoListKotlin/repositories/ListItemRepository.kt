package com.example.toDoListKotlin.repositories

import com.example.toDoListKotlin.dto.ListItem
import com.example.toDoListKotlin.dto.ToDoList

interface ListItemRepository {
    suspend fun loadAll(listID: Long): List<ListItem>
    suspend fun add(listItem: ListItem): ListItem
    suspend fun update(listItem: ListItem)
}