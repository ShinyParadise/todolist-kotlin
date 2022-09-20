package com.example.toDoListKotlin.dto

data class ListItem(
    val id: Long,
    val description: String,
    var state: Boolean,
    val listID: Long
) {
    constructor(description: String, state: Boolean, listID: Long) : this(
        id = INVALID_ID,
        description = description,
        state = state,
        listID = listID
    )

    constructor(description: String, listID: Long) : this(
        id = INVALID_ID,
        description = description,
        state = false,
        listID = listID
    )

    constructor(description: String) : this(
        id = INVALID_ID,
        description = description,
        state = false,
        listID = INVALID_ID
    )

    companion object {
        const val INVALID_ID = Long.MAX_VALUE
    }
}
