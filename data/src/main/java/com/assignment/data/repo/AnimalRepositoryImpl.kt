package com.assignment.data.repo

import com.assignment.data.apiservice.ApiService
import com.assignment.data.extensions.toAnimalList
import com.assignment.domain.models.AnimalModel
import com.assignment.domain.repositories.AnimalRepository
import javax.inject.Inject


/**
 * Animal Repository for fetching Animal List
 * */

class AnimalRepoImpl @Inject constructor(
    private val apiService: ApiService
): AnimalRepository{

    lateinit var animalList : List<AnimalModel>

    override suspend fun getAllAnimals(): List<AnimalModel> {
        animalList = apiService.getAnimals().map {
            it.toAnimalList() }
        return animalList
    }

    override suspend fun getAnimalDetail(selectedItem : Int): AnimalModel {
        return animalList.get(selectedItem)
    }


}