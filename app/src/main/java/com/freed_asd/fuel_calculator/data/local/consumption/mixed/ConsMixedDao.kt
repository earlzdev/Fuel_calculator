package com.freed_asd.fuel_calculator.data.local.consumption.mixed

import androidx.room.*
import com.freed_asd.fuel_calculator.data.local.consumption.city.ConsCity

@Dao
interface ConsMixedDao {

    @Query("SELECT * FROM ConsMixedDB")
    fun allValues() : List<ConsCity>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
     fun insertValue(value: ConsMixed)

//    @Query("DELETE FROM ConsMixedDB WHERE id = :id")
    @Delete
     fun deleteValue(value: ConsMixed)
//
//    @Query("DELETE FROM ConsMixedDB")
//    suspend fun clearDataBase()
}