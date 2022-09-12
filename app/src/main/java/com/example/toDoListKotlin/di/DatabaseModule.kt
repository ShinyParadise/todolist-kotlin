package com.example.toDoListKotlin.di

import android.content.Context
import androidx.room.Room
import com.example.toDoListKotlin.db.AppDatabase
import com.example.toDoListKotlin.db.dao.ToDoListDAO
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class DatabaseModule {
    @Provides
    @Singleton
    fun provideAppDatabase(@ApplicationContext appContext: Context): AppDatabase {
        return Room
            .databaseBuilder(
                appContext,
                AppDatabase::class.java,
                "todolist.db"
            ).build()
    }

    @Provides
    fun provideToDoListDAO(database: AppDatabase): ToDoListDAO {
        return database.toDoListDAO()
    }
}
