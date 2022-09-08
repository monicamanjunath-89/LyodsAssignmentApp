package com.assignment.data.apiservice

import com.assignment.domain.models.AnimalModel
import retrofit2.http.GET


interface ApiService {
    @GET("rand/10")
    suspend fun getAnimals(): List<AnimalModel>
}