package com.freed_asd.fuel_calculator.data.local.consumption.mixed

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.freed_asd.fuel_calculator.data.local.consumption.city.ConsCity

@Dao
interface ConsMixedDao {

    @Query("SELECT * FROM ConsMixedDB")
    fun allValues() : List<ConsCity>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertValue(value: ConsMixed)

    @Query("DELETE FROM ConsMixedDB WHERE id = :id")
    suspend fun deleteValue(id: Long)

    @Query("DELETE FROM ConsMixedDB")
    suspend fun clearDataBase()
}