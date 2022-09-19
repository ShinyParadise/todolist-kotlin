package com.example.toDoListKotlin.db

import androidx.room.AutoMigration
import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.toDoListKotlin.db.dao.ListItemDAO
import com.example.toDoListKotlin.db.dao.ToDoListDAO
import com.example.toDoListKotlin.db.entities.ListItem
import com.example.toDoListKotlin.db.entities.ToDoList

@Database(
    version = 2,
    entities = [ToDoList::class, ListItem::class],
    autoMigrations = [
        AutoMigration(from = 1, to = 2)
    ]
)
abstract class AppDatabase : RoomDatabase() {
    abstract fun toDoListDAO(): ToDoListDAO
    abstract fun listItemDAO(): ListItemDAO
}
