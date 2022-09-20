package com.assignment.data.extensions

import com.assignment.data.model.DataModel
import com.assignment.domain.models.AnimalModel

fun DataModel.toAnimalList(): AnimalModel {
    return AnimalModel(
        animalName,
        animalLatinName,
        type,
        animalActiveTime,
        minLen,
        maxLen,
        minWeight,
        maxWeight,
        animalLifespan,
        animalHabitat,
        animalDiet,
        geoRange,
        image,
        animalId
    )
}