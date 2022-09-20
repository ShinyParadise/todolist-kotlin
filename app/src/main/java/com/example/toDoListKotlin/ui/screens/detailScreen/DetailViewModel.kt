package com.example.toDoListKotlin.ui.screens.detailScreen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.example.toDoListKotlin.dto.ListItem
import com.example.toDoListKotlin.dto.ToDoList
import com.example.toDoListKotlin.repositories.ListItemRepository
import dagger.assisted.Assisted
import dagger.assisted.AssistedInject
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch

class DetailViewModel @AssistedInject constructor (
    private val repository: ListItemRepository,
    @Assisted private val toDoList: ToDoList
) : ViewModel() {
    private val _savedDescription = MutableStateFlow("")
    val savedDescription = _savedDescription.asStateFlow()

    private val _listItems: MutableStateFlow<List<ListItem>> = MutableStateFlow(emptyList())
    val listItems: StateFlow<List<ListItem>> = _listItems.asStateFlow()

    init { viewModelScope.launch { _listItems.value = repository.loadAll(toDoList) } }

    suspend fun addListItem() {
        if (savedDescription.value.isNotBlank()) {
            repository.add(ListItem(
                description = savedDescription.value,
                listID = toDoList.id
            ))
            _listItems.value = repository.loadAll(toDoList)
        }
    }

    suspend fun changeItemState(listItem: ListItem) {
        listItem.state = !listItem.state
        repository.update(listItem)
        _listItems.value = repository.loadAll(toDoList)
    }

    fun setSavedDescription(description: String) {
        _savedDescription.value = description
    }

    @dagger.assisted.AssistedFactory
    interface AssistedFactory {
        fun create(toDoList: ToDoList): DetailViewModel
    }

    @Suppress("UNCHECKED_CAST")
    companion object {
        fun provideFactory(
            assistedFactory: AssistedFactory,
            toDoList: ToDoList
        ): ViewModelProvider.Factory = object : ViewModelProvider.Factory {
            override fun <T : ViewModel> create(modelClass: Class<T>): T {
                return assistedFactory.create(toDoList) as T
            }
        }
    }
}

