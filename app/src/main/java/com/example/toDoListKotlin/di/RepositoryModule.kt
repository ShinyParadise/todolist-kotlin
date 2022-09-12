package com.example.toDoListKotlin.di

import com.example.toDoListKotlin.repositories.ListRepository
import com.example.toDoListKotlin.repositories.ListRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {
    @Singleton
    @Binds
    abstract fun provideListsRepository(repository: ListRepositoryImpl): ListRepository
}
