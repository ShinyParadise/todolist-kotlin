package com.example.toDoListKotlin.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.toDoListKotlin.db.dao.ToDoListDAO
import com.example.toDoListKotlin.db.entities.ToDoList

@Database(version = 1, entities = [ToDoList::class])
abstract class AppDatabase : RoomDatabase() {
    abstract fun toDoListDAO(): ToDoListDAO

    companion object {
        private var INSTANCE: AppDatabase? = null

        fun getInstance(context: Context): AppDatabase {
            if (INSTANCE == null) {
                synchronized(AppDatabase::class) {
                    INSTANCE = Room.databaseBuilder(
                        context,
                        AppDatabase::class.java, "todolist.db"
                    ).build()
                }
            }
            return INSTANCE!!
        }
    }
}
