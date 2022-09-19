package com.example.toDoListKotlin.repositories

import com.example.toDoListKotlin.dto.ListItem

interface ListItemRepository {
    suspend fun loadAll(): List<ListItem>
    suspend fun add(listItem: ListItem): ListItem
}