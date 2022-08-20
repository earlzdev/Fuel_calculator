package com.freed_asd.fuel_calculator.domain.tripPrice

import com.freed_asd.fuel_calculator.data.Repository
import com.freed_asd.fuel_calculator.data.tripPrice.PriceInputData
import com.freed_asd.fuel_calculator.data.tripPrice.PriceResultData
import com.freed_asd.fuel_calculator.data.tripPrice.dbItem.PriceDbItemData
import kotlinx.coroutines.flow.Flow

interface CalcTripPriceRepository : Repository{

    fun calcTripPrice(data: PriceInputData) : PriceResultData

    suspend fun insertIntoDb(value: PriceDbItemData)

    fun allDbValues() : Flow<List<PriceDbItemData>>

    suspend fun itemById(itemId: Long) : PriceDbItemData

    suspend fun deleteItem(itemId: Long)

    suspend fun updateItem(item: Long, newName: String)
}