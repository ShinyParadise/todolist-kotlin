package com.example.toDoListKotlin.db.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.ForeignKey.SET_NULL
import androidx.room.PrimaryKey

@Entity(
    tableName = "list_items",
    foreignKeys = [ForeignKey(
        entity = ToDoList::class,
        parentColumns = arrayOf("id"),
        childColumns = arrayOf("listID")
    )]
)
data class ListItem(
    @PrimaryKey(autoGenerate = true) val id: Long = 0,
    val description: String,
    var isChecked: Boolean = false,
    @ColumnInfo(index = true) val listID: Long
)
