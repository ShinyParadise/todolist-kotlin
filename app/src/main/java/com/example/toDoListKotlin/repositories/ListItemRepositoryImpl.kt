package com.example.toDoListKotlin.repositories

import com.example.toDoListKotlin.db.dao.ListItemDAO
import com.example.toDoListKotlin.dto.ListItem
import com.example.toDoListKotlin.dto.ToDoList
import javax.inject.Inject
import com.example.toDoListKotlin.db.entities.ListItem as dbListItem

class ListItemRepositoryImpl @Inject constructor (private val dao: ListItemDAO)
    : ListItemRepository {
    override suspend fun loadAll(listID: Long): List<ListItem> {
        val listItemEntities = dao.getAllListItems(listID.toString())

        val listItems = listItemEntities.map {
            ListItem(it.id, it.description, it.isChecked, it.listID)
        }

        return listItems
    }

    override suspend fun add(listItem: ListItem): ListItem {
        val dbListItem = dbListItem(
            description = listItem.description,
            isChecked = listItem.state,
            listID = listItem.listID
        )

        val insertedRowID = dao.insert(dbListItem)

        return listItem.copy(id = insertedRowID)
    }

    override suspend fun update(listItem: ListItem) {
        dao.update(dbListItem(
            id = listItem.id,
            description = listItem.description,
            isChecked = listItem.state,
            listID = listItem.listID
        ))
    }
}