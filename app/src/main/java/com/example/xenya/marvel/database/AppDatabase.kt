package com.example.xenya.marvel.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.xenya.marvel.entities.Result

@Database(entities = [Result::class], version = 2)
abstract class AppDatabase : RoomDatabase() {
    companion object {
        const val DATABASE_NAME = "marvel"
        private var instance: AppDatabase? = null

        fun getInstance(context: Context): AppDatabase =
                instance ?: buildDatabase(context.applicationContext).also { instance = it }

        private fun buildDatabase(context: Context): AppDatabase =
                Room.databaseBuilder(context, AppDatabase::class.java, DATABASE_NAME)
                        .fallbackToDestructiveMigration()
                        .build()
    }

    abstract fun getMarvelDao(): MarvelDao
}
