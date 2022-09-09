package com.example.toDoListKotlin.dto

data class ToDoList(
    val id: Long,
    val name: String,
    val description: String?
) {
    constructor(name: String, description: String?) : this(
        id = INVALID_ID,
        name = name,
        description = description
    )

    companion object {
        const val INVALID_ID = Long.MAX_VALUE
    }
}
