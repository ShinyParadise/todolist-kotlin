package com.example.toDoListKotlin.db.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.toDoListKotlin.db.entities.ListItem

@Dao
interface ListItemDAO {
    @Insert
    suspend fun insert(listItem: ListItem): Long

    @Query("SELECT * FROM list_items")
    suspend fun getAll(): List<ListItem>
}