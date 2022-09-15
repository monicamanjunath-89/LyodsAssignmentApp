package com.assignment.data.extensions

import com.assignment.data.model.DataModel
import com.assignment.domain.models.AnimalModel

fun DataModel.toAnimalList(): AnimalModel {
    return AnimalModel(
        name,
        latin_name,
        animal_type,
        active_time,
        length_min,
        length_max,
        weight_min,
        weight_max, lifespan,
        habitat, diet,
        geo_range,
        image_link,
        id
    )
}