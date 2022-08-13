package com.freed_asd.fuel_calculator.data.local.price

import androidx.room.*

@Dao
interface PriceDao {

    @Query("SELECT * FROM priceDb")
    fun allValues() : List<PriceDb>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insertValue(value: PriceDb)

    //    @Query("DELETE FROM ConsCityDB WHERE id = :id")
    @Delete
    fun deleteValue(value: PriceDb)
}