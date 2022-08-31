package com.example.toDoListKotlin.dto

import java.util.*

class ToDoList(var header: String, var description: String) {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other == null || javaClass != other.javaClass) return false
        val toDoList = other as ToDoList
        return if (header != toDoList.header) false else description == toDoList.description
    }

    override fun hashCode(): Int {
        return Objects.hash(header, description)
    }
}