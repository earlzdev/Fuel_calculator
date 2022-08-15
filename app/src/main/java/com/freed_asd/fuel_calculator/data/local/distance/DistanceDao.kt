package com.freed_asd.fuel_calculator.data.local.distance

import androidx.room.*

@Dao
interface DistanceDao {

    @Query("SELECT * FROM distanceDb")
    fun allValues() : List<DistanceDb>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insertValue(value: DistanceDb)

    @Query("DELETE FROM ConsCityDB WHERE id = :itemId")
    fun deleteValue(itemId: Long)
}