package com.example.toDoListKotlin.dto

data class ListItem(
    val id: Long,
    val description: String,
    val state: Boolean,
    val listID: Long
) {
    constructor(description: String, state: Boolean, listID: Long) : this(
        id = INVALID_ID,
        description = description,
        state = state,
        listID = listID
    )

    constructor(description: String, state: Boolean) : this(
        id = INVALID_ID,
        description = description,
        state = state,
        listID = INVALID_ID
    )

    companion object {
        const val INVALID_ID = Long.MAX_VALUE
    }
}
