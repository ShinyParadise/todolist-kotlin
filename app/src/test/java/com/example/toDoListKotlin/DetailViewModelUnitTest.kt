package com.example.toDoListKotlin

import com.example.toDoListKotlin.dto.ListItem
import com.example.toDoListKotlin.dto.ToDoList
import com.example.toDoListKotlin.repositories.ListItemRepository
import com.example.toDoListKotlin.ui.screens.detailScreen.DetailViewModel
import io.mockk.coEvery
import io.mockk.coJustRun
import io.mockk.mockk
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.test.StandardTestDispatcher
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
    private val testListItem = ListItem(1, "description", false, testToDoList.id)

    @OptIn(ExperimentalCoroutinesApi::class)
    private val dispatcher = StandardTestDispatcher()

    @OptIn(ExperimentalCoroutinesApi::class)
    @Before
    fun setup() {
        Dispatchers.setMain(dispatcher)

        mockRepository = mockk()
        coJustRun { mockRepository.update(any()) }

        sut = DetailViewModel(repository = mockRepository, listID = testToDoList.id)
    }

    @OptIn(ExperimentalCoroutinesApi::class)
    @After
    fun tearDown() {
        Dispatchers.resetMain()
    }

    @Test
    fun `test add one item`() {
        coEvery { mockRepository.loadAll(testToDoList.id) } returns listOf(testListItem)
        coEvery { mockRepository.add(any()) } returns testListItem

        sut.setSavedDescription("teest")
        runBlocking {
            sut.addListItem()
        }

        assertEquals(listOf(testListItem), sut.listItems.value)
    }

    @Test
    fun `test init values`() {
        val emptyListOfItems: List<ListItem> = emptyList()

        assertEquals("", sut.savedDescription.value)
        assertEquals(emptyListOfItems, sut.listItems.value)
    }

    @Test
    fun `test change item state`() {
        coEvery { mockRepository.loadAll(testToDoList.id) } returns listOf(testListItem)
        runBlocking { sut.changeItemState(testListItem) }

        val changedState = sut.listItems.value[0].state
        assertTrue(changedState)
    }
}