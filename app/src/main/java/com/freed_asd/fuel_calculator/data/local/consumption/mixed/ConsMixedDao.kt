package com.freed_asd.fuel_calculator.data.local.consumption.mixed

import androidx.room.*
import com.freed_asd.fuel_calculator.data.local.consumption.city.ConsCity
import kotlinx.coroutines.flow.Flow

@Dao
interface ConsMixedDao {

    @Query("SELECT * FROM ConsMixedDB")
    fun allValues() : Flow<List<ConsMixed>>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertValue(value: ConsMixed)

    @Query("DELETE FROM ConsMixedDB WHERE id = :itemId")
    fun deleteValue(itemId: Long)

    @Query("DELETE FROM ConsMixedDB")
    suspend fun clearDataBase()
}