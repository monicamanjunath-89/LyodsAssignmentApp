package com.assignment.lloydsassignmentapp.viewmodel

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.assignment.domain.mock.MockData
import com.assignment.domain.models.AnimalModel
import com.assignment.domain.usecases.GetAllAnimalsUsecase
import com.assignment.lloydsassignmentapp.MainDispatcherRule
import com.nhaarman.mockitokotlin2.whenever
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.test.*
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.rules.TestRule
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.junit.MockitoJUnitRunner

@ExperimentalCoroutinesApi
@RunWith(MockitoJUnitRunner::class)
class AnimalListViewModelTest {
    @get:Rule
    val testInstantTaskExecutorRule: TestRule = InstantTaskExecutorRule()
    @ExperimentalCoroutinesApi
    @get:Rule
    val mainDispatcherRule = MainDispatcherRule()

    private lateinit var viewModel: AnimalListViewModel
    @Mock
    private lateinit var getAllAnimalsUsecase: GetAllAnimalsUsecase

    @Before
    fun setUp() {
        viewModel = AnimalListViewModel(getAllAnimalsUsecase)
    }

    @Test
    fun testGetAnimalList() {
        runTest {
            whenever(getAllAnimalsUsecase()).thenAnswer {
                MockData.getAnimalList()
            }

            val dispatcher = UnconfinedTestDispatcher(testScheduler)
            val results = mutableListOf<AnimalModel>()
            val job = launch(dispatcher) { viewModel.resultFlow.toList(results) }

            viewModel.getAnimalList()
            runCurrent()
            assertEquals(MockData.animals.size, viewModel.resultFlow.value.data?.size)
            job.cancel()
        }
    }
}

private fun <T> MutableStateFlow<T>.toList(destination: MutableList<AnimalModel>) {
}
