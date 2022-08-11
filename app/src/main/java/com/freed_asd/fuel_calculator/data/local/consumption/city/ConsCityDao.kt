package com.freed_asd.fuel_calculator.data.local.consumption.city

import androidx.room.*

@Dao
interface ConsCityDao {

    @Query("SELECT * FROM ConsCityDB")
    fun allValues() : List<ConsCity>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insertValue(value: ConsCity)

//    @Query("DELETE FROM ConsCityDB WHERE id = :id")
    @Delete
    fun deleteValue(value: ConsCity)
//
//    @Query("DELETE FROM ConsCityDB")
//    suspend fun clearDataBase()
}