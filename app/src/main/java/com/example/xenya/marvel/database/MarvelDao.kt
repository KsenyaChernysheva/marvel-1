package com.example.xenya.marvel.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.xenya.marvel.entities.Result
import io.reactivex.Flowable
import io.reactivex.Single

@Dao
interface MarvelDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun saveAll(list: List<Result?>)

    @Query("SELECT * FROM result")
    fun getAll(): Single<List<Result>>

    @Query("SELECT * FROM result WHERE id = :id")
    fun getCharacterById(id: Int): Flowable<Result>
}
