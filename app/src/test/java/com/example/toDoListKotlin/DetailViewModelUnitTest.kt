package com.example.toDoListKotlin

import com.example.toDoListKotlin.dto.ToDoList
import com.example.toDoListKotlin.repositories.ListItemRepository
import com.example.toDoListKotlin.ui.screens.detailScreen.DetailViewModel
import io.mockk.coEvery
import io.mockk.mockk
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.TestCoroutineDispatcher
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.setMain
import org.junit.After
import org.junit.Test

import org.junit.Assert.*
import org.junit.Before

class DetailViewModelUnitTest {
    private lateinit var sut: DetailViewModel
    private lateinit var mockRepository: ListItemRepository
    private val testToDoList = ToDoList(1, "test", "test")

    private val dispatcher = TestCoroutineDispatcher()

    @OptIn(ExperimentalCoroutinesApi::class)
    @Before
    fun setup() {
        Dispatchers.setMain(dispatcher)
        mockRepository = mockk()
        sut = DetailViewModel(repository = mockRepository, toDoList = testToDoList)
    }

    @OptIn(ExperimentalCoroutinesApi::class)
    @After
    fun tearDown() {
        Dispatchers.resetMain()
    }

    @Test
    fun `test change item state`() {
        sut.changeSavedItemState()
        assertTrue(sut.savedItemState.value)
    }

    @Test
    fun `test add one item`() {
        sut.setSavedDescription("teest")
        coEvery { mockRepository.loadAll() } returns emptyList()

    }
}