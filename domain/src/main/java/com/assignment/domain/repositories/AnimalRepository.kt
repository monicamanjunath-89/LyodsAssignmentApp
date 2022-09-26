package com.assignment.domain.repositories

import com.assignment.domain.models.AnimalModel

interface AnimalRepository {
    suspend fun getAllAnimals(): List<AnimalModel>
    suspend fun getAnimalDetail(selectedItem : Int) : AnimalModel
}