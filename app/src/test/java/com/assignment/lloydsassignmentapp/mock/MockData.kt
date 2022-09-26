package com.assignment.domain.mock

import com.assignment.domain.common.Resource
import com.assignment.domain.models.AnimalModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

object MockData {
    val animals = listOf(
        AnimalModel(
            id = 1,
            name = "Koala",
            latinName = "koala",
            animalType = "mammal",
            activeTime = "10",
            lengthMin = 1.9,
            lengthMax = 2.3,
            weightMin = 15.0,
            weightMax = 30.0,
            lifespan = 15,
            habitat = "forest",
            diet = "fruits",
            geoRange = "australia",
            imageLink = "https://mock.url"
        ),
        AnimalModel(
            id = 2,
            name = "penguin",
            latinName = "penguin",
            animalType = "bird",
            activeTime = "10",
            lengthMin = 1.9,
            lengthMax = 2.3,
            weightMin = 15.0,
            weightMax = 30.0,
            lifespan = 15,
            habitat = "ice",
            diet = "fish",
            geoRange = "antartica",
            imageLink = "https://mock.url"
        ),
        AnimalModel(
            id = 3,
            name = "Tiger",
            latinName = "Tiger",
            animalType = "mammal",
            activeTime = "10",
            lengthMin = 1.9,
            lengthMax = 2.3,
            weightMin = 15.0,
            weightMax = 30.0,
            lifespan = 15,
            habitat = "forest",
            diet = "meat",
            geoRange = "india",
            imageLink = "https://mock.url"
        )
    )

    fun getAnimalList(): Flow<Resource<List<AnimalModel>>> = flow {
        emit(Resource.Success(animals))
    }

    fun getAnimalDetail(item: Int): Flow<Resource<AnimalModel>> = flow {
        emit(Resource.Success(animals.get(item)))
    }
}

