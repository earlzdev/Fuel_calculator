package com.freed_asd.fuel_calculator.data.local.price

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface PriceDao {

    @Query("SELECT * FROM priceDb")
    fun allValues() : List<PriceDb>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertValue(value: PriceDb)

    @Query("DELETE FROM priceDb WHERE id = :itemId")
    suspend fun deleteValue(itemId: Long)

    @Query("SELECT * FROM priceDb WHERE id = :itemId")
    suspend fun itemById(itemId: Long) : PriceDb

    @Query("update priceDb set name = :newName where id = :item")
    suspend fun updateItem(item: Long, newName: String)
}