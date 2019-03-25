package com.example.xenya.marvel.database

import android.content.Context
import androidx.room.Room
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class DatabaseModule(private var context: Context) {

    companion object {
        private const val DATABASE_NAME = "marvel"
    }

    @Provides
    @Singleton
    fun provideDatabase(): AppDatabase =
            Room.databaseBuilder(context, AppDatabase::class.java, DATABASE_NAME)
                    .fallbackToDestructiveMigration()
                    .build()

    @Provides
    @Singleton
    fun provideMarvelDao(appDatabase: AppDatabase): MarvelDao = appDatabase.getMarvelDao()
}
