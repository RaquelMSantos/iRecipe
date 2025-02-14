package com.rmso.irecipe.presentation.features.signin

import app.cash.turbine.testIn
import com.rmso.irecipe.data.remote.api.Result
import com.rmso.irecipe.domain.model.AuthUser
import com.rmso.irecipe.domain.usecase.SignInUseCase
import io.mockk.coEvery
import io.mockk.mockk
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.test.StandardTestDispatcher
import kotlinx.coroutines.test.TestScope
import kotlinx.coroutines.test.advanceTimeBy
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.runTest
import kotlinx.coroutines.test.setMain
import org.junit.After
import org.junit.Assert.assertEquals
import org.junit.Assert.assertFalse
import org.junit.Assert.assertTrue
import org.junit.Before
import org.junit.Test

@OptIn(ExperimentalCoroutinesApi::class)
class SignInViewModelTest {
    private val testDispatcher = StandardTestDispatcher()
    private val signInUseCase: SignInUseCase = mockk()
    private val viewModel = SignInViewModel(signInUseCase, testDispatcher)
    private val effectTurbine = viewModel.uiAction.testIn(TestScope(testDispatcher))

    @Before
    fun setup() {
        Dispatchers.setMain(testDispatcher)
    }

    @After
    fun teardown() {
        Dispatchers.resetMain()
    }

    @Test
    fun `GIVEN error WHEN signInUser THEN errorMessage is not empty`(): Unit =
        runTest {
            val errorMessage = "mensagem de erro"
            coEvery {
                signInUseCase(any(), any())
            } returns flow { emit(Result.Error(errorMessage)) }

            viewModel.signInUser()
            advanceTimeBy(1000)
            assertEquals(
                viewModel.uiState.value,
                SignInState(errorMessage = errorMessage)
            )
        }

    @Test
    fun `GIVEN success WHEN signInUser THEN should be NavigateToHome`(): Unit =
        runTest {
            val mockSuccess = AuthUser()
            coEvery {
                signInUseCase(any(), any())
            } returns flow { emit(Result.Success(data = mockSuccess)) }

            viewModel.signInUser()
            assertEquals(effectTurbine.awaitItem(), SignInAction.NavigateToHome)
        }

    @Test
    fun `WHEN updateShowPassword THEN isShowPassword changed`(): Unit =
        runTest {
            assertFalse(viewModel.uiState.value.isShowPassword)
            viewModel.updateShowPassword()
            assertTrue(viewModel.uiState.value.isShowPassword)
        }

    @Test
    fun `GIVEN new password WHEN updatePassword THEN password changed`(): Unit =
        runTest {
            val newPassword = "1234"
            viewModel.updatePassword(newPassword)
            assertEquals(viewModel.uiState.value.password, newPassword)
        }
}
