package com.example.toDoListKotlin.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.toDoListKotlin.db.dao.ToDoListDAO
import com.example.toDoListKotlin.db.entities.ToDoList

@Database(version = 1, entities = [ToDoList::class])
abstract class AppDatabase : RoomDatabase() {
    abstract fun toDoListDAO(): ToDoListDAO
}
