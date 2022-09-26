package com.assignment.data.di

import com.assignment.data.apiservice.ApiService
import com.assignment.data.repo.AnimalRepoImpl
import com.assignment.domain.repositories.AnimalRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class DataModule{

    @Provides
    @Singleton
    fun provideAnimalRepository(api: ApiService): AnimalRepository {
        return AnimalRepoImpl(api)
    }
}