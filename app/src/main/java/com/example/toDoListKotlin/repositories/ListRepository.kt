package com.example.toDoListKotlin.repositories

import com.example.toDoListKotlin.dto.ListItem

interface ListRepository {
    suspend fun loadAll(): List<ListItem>
    suspend fun add(list: ListItem): ListItem
}
