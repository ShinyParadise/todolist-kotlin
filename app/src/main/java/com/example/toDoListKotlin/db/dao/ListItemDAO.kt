package com.example.toDoListKotlin.db.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.example.toDoListKotlin.db.entities.ListItem

@Dao
interface ListItemDAO {
    @Insert
    suspend fun insert(listItem: ListItem): Long

    @Update
    suspend fun update(listItem: ListItem)

    @Query("SELECT * FROM list_items WHERE listID = :listID")
    suspend fun getAllListItems(listID: String): List<ListItem>
}