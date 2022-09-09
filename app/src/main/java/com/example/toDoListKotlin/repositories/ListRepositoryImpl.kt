package com.example.toDoListKotlin.repositories

import com.example.toDoListKotlin.db.dao.ToDoListDAO
import com.example.toDoListKotlin.dto.ToDoList
import com.example.toDoListKotlin.db.entities.ToDoList as dbList

class ListRepositoryImpl(private val dao: ToDoListDAO): ListRepository {
    override suspend fun loadAll(): List<ToDoList> {
        val listEntities = dao.getAll()

        val toDoLists = listEntities.map {
            ToDoList(it.id, it.name, it.description)
        }

        return toDoLists
    }

    override suspend fun add(list: ToDoList): ToDoList {
        val dbList = dbList(name = list.name, description = list.description)
        val insertedRowID = dao.insert(dbList)

        return list.copy(id = insertedRowID)
    }
}
