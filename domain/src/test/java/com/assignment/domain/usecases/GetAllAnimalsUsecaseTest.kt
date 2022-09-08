package com.assignment.domain.usecases

import com.assignment.domain.mock.MockData
import com.assignment.domain.models.AnimalModel
import com.assignment.domain.repositories.AnimalRepository
import com.nhaarman.mockitokotlin2.whenever
import junit.framework.Assert.assertEquals
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.*
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.junit.MockitoJUnitRunner

@ExperimentalCoroutinesApi
@RunWith(MockitoJUnitRunner::class)
class GetAllAnimalsUsecaseTest  {

    @ExperimentalCoroutinesApi
    private val testDispatcher = StandardTestDispatcher()

    @Mock
    private lateinit var animalRepository: AnimalRepository
    private var animalList = mutableListOf<AnimalModel>()

    @Before
    fun setUp() {
        Dispatchers.setMain(testDispatcher)
    }

    @After
    fun tearDown() {
        Dispatchers.resetMain()
    }

    @ExperimentalCoroutinesApi
    @Test
    fun testGetAllAnimalsUseCase() = runBlockingTest {
        whenever(animalRepository.getAllAnimals())
            .thenReturn(MockData.animals)
        animalList = animalRepository.getAllAnimals() as MutableList<AnimalModel>
        assertEquals(animalList.size, MockData.animals.size)
    }
}


