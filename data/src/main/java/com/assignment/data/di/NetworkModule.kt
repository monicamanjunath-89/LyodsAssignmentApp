package com.assignment.data.di

import com.assignment.data.apiservice.ApiService
import com.assignment.data.repo.AnimalRepoImpl
import com.assignment.domain.common.Constants.BASE_URL
import com.assignment.domain.repositories.AnimalRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class NetworkModule{

    @Provides
    @Singleton
    fun provideApiService(): ApiService {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(ApiService::class.java)
    }

    @Provides
    @Singleton
    fun provideAnimalRepository(api: ApiService): AnimalRepository {
        return AnimalRepoImpl(api)
    }

}