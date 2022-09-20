package com.example.toDoListKotlin

import com.example.toDoListKotlin.dto.ToDoList
import com.example.toDoListKotlin.repositories.ListItemRepository
import com.example.toDoListKotlin.ui.screens.detailScreen.DetailViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.TestCoroutineDispatcher
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.setMain
import org.junit.After
import org.junit.Test

import org.junit.Assert.*
import org.junit.Before
import org.mockito.Mockito.mock

class DetailViewModelUnitTest {
    private lateinit var sut: DetailViewModel
    private val testToDoList = ToDoList(1, "test", "test")

    private val dispatcher = TestCoroutineDispatcher()

    @OptIn(ExperimentalCoroutinesApi::class)
    @Before
    fun setup() {
        Dispatchers.setMain(dispatcher)
        val mockRepository = mock(ListItemRepository::class.java)
        sut = DetailViewModel(repository = mockRepository, toDoList = testToDoList)
    }

    @After
    fun tearDown() {
        Dispatchers.resetMain()
    }

    @Test
    fun `test change item state`() {
        sut.changeSavedItemState()
        assertTrue(sut.savedItemState.value)
    }
}