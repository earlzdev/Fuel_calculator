package com.freed_asd.fuel_calculator.data.local.consumption.city

import androidx.room.*
import kotlinx.coroutines.flow.Flow

@Dao
interface ConsCityDao {

    @Query("SELECT * FROM ConsCityDB")
    fun allValues() : Flow<List<ConsCity>>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insertValue(value: ConsCity)

    @Query("DELETE FROM ConsCityDB WHERE id = :itemId")
    fun deleteValue(itemId: Long)
//
//    @Query("DELETE FROM ConsCityDB")
//    suspend fun clearDataBase()
}