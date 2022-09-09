package com.example.toDoListKotlin.db.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "lists")
data class ToDoList(
    @PrimaryKey(autoGenerate = true) val id: Long = 0,
    val name: String,
    val description: String?
)
