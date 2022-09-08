package com.example.toDoListKotlin.dto

data class ToDoList(
    val listID: Int,
    val name: String,
    val description: String?
) {
    constructor(name: String, description: String?) : this(
        listID = INVALID_ID,
        name = name,
        description = description
    )

    companion object {
        const val INVALID_ID = Int.MAX_VALUE
    }
}
