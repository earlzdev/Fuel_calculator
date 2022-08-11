package com.freed_asd.fuel_calculator.data.local.consumption.track

import androidx.room.*
import com.freed_asd.fuel_calculator.data.local.consumption.city.ConsCity

@Dao
interface ConsTrackDao {

    @Query("SELECT * FROM ConsTrackDB")
    fun allValues() : List<ConsCity>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
     fun insertValue(value: ConsTrack)

//    @Query("DELETE FROM ConsTrackDB WHERE id = :id")
    @Delete
     fun deleteValue(value: ConsTrack)

//    @Query("DELETE FROM ConsTrackDB")
//    suspend fun clearDataBase()
}