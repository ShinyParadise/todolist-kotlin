package com.example.toDoListKotlin.repositories

import com.example.toDoListKotlin.db.dao.ListItemDAO
import com.example.toDoListKotlin.dto.ListItem
import javax.inject.Inject
import com.example.toDoListKotlin.db.entities.ListItem as dbListItem

class ListItemRepositoryImpl @Inject constructor (private val dao: ListItemDAO)
    : ListItemRepository {
    override suspend fun loadAll(): List<ListItem> {
        val listItemEntities = dao.getAll()

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
}