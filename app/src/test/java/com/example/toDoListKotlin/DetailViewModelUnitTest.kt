package com.example.toDoListKotlin

import com.example.toDoListKotlin.ui.screens.detailScreen.DetailViewModel
import org.junit.Test

import org.junit.Assert.*
import org.junit.Before

class DetailViewModelUnitTest {
    private lateinit var sut: DetailViewModel

    @Before
    fun setup() {
        sut = DetailViewModel()
    }

    @Test
    fun `test change item state`() {
        sut.changeSavedItemState()
        assertTrue(sut.savedItemState.value)
    }
}