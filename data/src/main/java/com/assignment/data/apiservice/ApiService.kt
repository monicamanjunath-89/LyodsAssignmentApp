package com.assignment.data.apiservice

import com.assignment.data.model.DataModel
import retrofit2.http.GET


interface ApiService {
    @GET("rand/10")
    suspend fun getAnimals(): List<DataModel>
}