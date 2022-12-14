package com.example.toDoListKotlin.db.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.toDoListKotlin.db.entities.ToDoList

@Dao
interface ToDoListDAO {
    @Insert
    suspend fun insert(toDoList: ToDoList): Long

    @Query("SELECT * FROM lists")
    suspend fun getAll(): List<ToDoList>
}
