package com.freed_asd.fuel_calculator.data.local.consumption.mileage

import androidx.room.*

@Dao
interface MileageDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertValue(value: MileageDbModel)

    @Query("select * from MileageTable where id =:valueId")
    suspend fun getValue(valueId: Long)

    @Query("delete from MileageTable")
    suspend fun clear()
}