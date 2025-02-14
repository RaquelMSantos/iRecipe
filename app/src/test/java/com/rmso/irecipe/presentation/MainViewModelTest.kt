package com.rmso.irecipe.presentation

import com.rmso.irecipe.domain.usecase.HasUserUseCase
import io.mockk.coEvery
import io.mockk.mockk
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.StandardTestDispatcher
import kotlinx.coroutines.test.advanceTimeBy
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.runTest
import kotlinx.coroutines.test.setMain
import org.junit.After
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test

@OptIn(ExperimentalCoroutinesApi::class)
class MainViewModelTest {

    private val testDispatcher = StandardTestDispatcher()
    private val hasUserUseCase: HasUserUseCase = mockk()
    private val viewModel = MainViewModel(hasUserUseCase, testDispatcher)

    @Before
    fun setup() {
        Dispatchers.setMain(testDispatcher)
    }

    @After
    fun teardown() {
        Dispatchers.resetMain()
    }

    @Test
    fun `GIVEN user WHEN onStart is called THEN sets isReady to true and hasUser to true`(): Unit =
        runTest {
            coEvery { hasUserUseCase.invoke() } returns true

            viewModel.onStart()
            advanceTimeBy(5000L)
            assertEquals(viewModel.uiState.value, MainState(isReady = true, hasUser = true))
        }

    @Test
    fun `GIVEN no user WHEN onStart is called THEN sets isReady to true and hasUser to false`(): Unit =
        runTest {
            coEvery { hasUserUseCase.invoke() } returns false

            viewModel.onStart()
            advanceTimeBy(5000L)
            assertEquals(viewModel.uiState.value, MainState(isReady = true, hasUser = false))
        }
}
