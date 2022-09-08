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
            latin_name = "koala",
            animal_type = "mammal",
            active_time = "10",
            length_min = 1.9,
            length_max = 2.3,
            weight_min = 15.0,
            weight_max = 30.0,
            lifespan = 15,
            habitat = "forest",
            diet = "fruits",
            geo_range = "australia",
            image_link = "https://mock.url"
        ),
        AnimalModel(
            id = 2,
            name = "penguin",
            latin_name = "penguin",
            animal_type = "bird",
            active_time = "10",
            length_min = 1.9,
            length_max = 2.3,
            weight_min = 15.0,
            weight_max = 30.0,
            lifespan = 15,
            habitat = "ice",
            diet = "fish",
            geo_range = "antartica",
            image_link = "https://mock.url"
        ),
        AnimalModel(
            id = 3,
            name = "Tiger",
            latin_name = "Tiger",
            animal_type = "mammal",
            active_time = "10",
            length_min = 1.9,
            length_max = 2.3,
            weight_min = 15.0,
            weight_max = 30.0,
            lifespan = 15,
            habitat = "forest",
            diet = "meat",
            geo_range = "india",
            image_link = "https://mock.url"
        )
    )

    fun getAnimalList(): Flow<Resource<List<AnimalModel>>> = flow {
        emit(Resource.Success(animals))
    }
}

