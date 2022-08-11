package com.freed_asd.fuel_calculator.data.local.consumption.track

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.freed_asd.fuel_calculator.data.local.consumption.city.ConsCity

@Dao
interface ConsTrackDao {

    @Query("SELECT * FROM ConsTrackDB")
    fun allValues() : List<ConsCity>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertValue(value: ConsTrack)

    @Query("DELETE FROM ConsTrackDB WHERE id = :id")
    suspend fun deleteValue(id: Long)

    @Query("DELETE FROM ConsTrackDB")
    suspend fun clearDataBase()
}