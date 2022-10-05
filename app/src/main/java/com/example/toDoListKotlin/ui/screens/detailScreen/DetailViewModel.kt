package com.example.toDoListKotlin.ui.screens.detailScreen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.example.toDoListKotlin.dto.ListItem
import com.example.toDoListKotlin.repositories.ListItemRepository
import dagger.assisted.Assisted
import dagger.assisted.AssistedInject
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class DetailViewModel @AssistedInject constructor (
    private val repository: ListItemRepository,
    @Assisted private val listID: Long
) : ViewModel() {
    private val _savedDescription = MutableStateFlow("")
    val savedDescription = _savedDescription.asStateFlow()

    private val _listItems: MutableStateFlow<List<ListItem>> = MutableStateFlow(emptyList())
    val listItems: StateFlow<List<ListItem>> = _listItems.asStateFlow()

    init { viewModelScope.launch { _listItems.value = repository.loadAll(listID) } }

    suspend fun addListItem() {
        if (savedDescription.value.isNotBlank()) {
            repository.add(ListItem(
                description = savedDescription.value,
                listID = listID
            ))
            _listItems.value = repository.loadAll(listID)
        }
    }

    suspend fun changeItemState(listItem: ListItem) {
        listItem.state = !listItem.state
        repository.update(listItem)
        _listItems.value = repository.loadAll(listID)
    }

    fun setSavedDescription(description: String) {
        _savedDescription.value = description
    }

    @dagger.assisted.AssistedFactory
    interface AssistedFactory {
        fun create(listID: Long): DetailViewModel
    }

    @Suppress("UNCHECKED_CAST")
    companion object {
        fun provideFactory(
            assistedFactory: AssistedFactory,
            listID: Long
        ): ViewModelProvider.Factory = object : ViewModelProvider.Factory {
            override fun <T : ViewModel> create(modelClass: Class<T>): T {
                return assistedFactory.create(listID) as T
            }
        }
    }
}

