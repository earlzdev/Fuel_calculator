package com.freed_asd.fuel_calculator.data.local.consumption.track

import androidx.room.*
import com.freed_asd.fuel_calculator.data.local.consumption.city.ConsCity
import kotlinx.coroutines.flow.Flow

@Dao
interface ConsTrackDao {

    @Query("SELECT * FROM ConsTrackDB")
    fun allValues() : Flow<List<ConsTrack>>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
     fun insertValue(value: ConsTrack)

    @Query("DELETE FROM ConsTrackDB WHERE id = :itemId")
     fun deleteValue(itemId: Long)

//    @Query("DELETE FROM ConsTrackDB")
//    suspend fun clearDataBase()
}