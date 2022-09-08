package com.assignment.data.repo

import com.assignment.data.apiservice.ApiService
import com.assignment.domain.models.AnimalModel
import com.assignment.domain.repositories.AnimalRepository
import javax.inject.Inject


/**
 * Animal Repository for fetching Animal List
 * */

class AnimalRepoImpl @Inject constructor(
    private val apiService: ApiService
): AnimalRepository{

    override suspend fun getAllAnimals(): List<AnimalModel> {
        return apiService.getAnimals()
    }
}