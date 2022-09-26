package com.assignment.lloydsassignmentapp.viewmodel

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.assignment.domain.mock.MockData
import com.assignment.domain.usecases.GetAnimalDetailsUsecase
import com.assignment.lloydsassignmentapp.MainDispatcherRule
import com.nhaarman.mockitokotlin2.whenever
import kotlinx.coroutines.ExperimentalCoroutinesApi
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
class AnimalDetailViewModelTest {
    @get:Rule
    val testInstantTaskExecutorRule: TestRule = InstantTaskExecutorRule()
    @ExperimentalCoroutinesApi
    @get:Rule
    val mainDispatcherRule = MainDispatcherRule()

    private lateinit var viewModel: AnimalDetailtViewModel
    @Mock
    private lateinit var getAnimalDetailUsecase: GetAnimalDetailsUsecase

    @Before
    fun setUp() {
        viewModel = AnimalDetailtViewModel(getAnimalDetailUsecase)
    }

    @Test
    fun testGetAnimalList() {
        runTest {
            whenever(getAnimalDetailUsecase(1)).thenAnswer {
                MockData.getAnimalDetail(1)
            }

            val dispatcher = UnconfinedTestDispatcher(testScheduler)
            val job = launch(dispatcher) { viewModel._resultFlow }

            viewModel.getAnimalDetail(1)
            runCurrent()
            assertEquals(MockData.animals.get(1), viewModel.resultFlow.value.data)
            job.cancel()
        }
    }
}