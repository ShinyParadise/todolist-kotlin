package com.example.toDoListKotlin.dto

data class ListItem(val id: Long, val description: String, val state: Boolean) {
    constructor(description: String, state: Boolean) : this(
        id = INVALID_ID,
        description = description,
        state = state
    )

    companion object {
        const val INVALID_ID = Long.MAX_VALUE
    }
}
