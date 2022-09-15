package com.assignment.domain.usecases

import com.assignment.domain.common.Resource
import com.assignment.domain.models.AnimalModel
import com.assignment.domain.repositories.AnimalRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import java.io.IOException
import javax.inject.Inject

class GetAllAnimalsUsecase @Inject constructor(
    private val animalRepository: AnimalRepository){

    operator fun invoke(): Flow<Resource<List<AnimalModel>>> = flow {
        try {
            emit(Resource.Loading())
            val animalList = animalRepository.getAllAnimals()
            emit(Resource.Success(animalList))
        } catch (e: IOException) {
            emit(Resource.Error("Couldn't reach server. Check your internet connection!"))
        } catch (e: Exception) {
            emit(Resource.Error("ERROR: " +e.message))
        }
    }
}