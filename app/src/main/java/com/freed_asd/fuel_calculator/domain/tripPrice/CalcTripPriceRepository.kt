package com.freed_asd.fuel_calculator.domain.tripPrice

import com.freed_asd.fuel_calculator.data.tripPrice.models.PriceInputData
import com.freed_asd.fuel_calculator.data.tripPrice.models.PriceResultData
import com.freed_asd.fuel_calculator.data.tripPrice.models.PriceDbItemData

interface CalcTripPriceRepository {

    fun calcTripPrice(data: PriceInputData) : PriceResultData

    suspend fun insertIntoDb(value: PriceDbItemData)

    suspend fun fetchAllPriceValuesFromDb() : List<PriceDbItemData>

    suspend fun itemById(itemId: Long) : PriceDbItemData

    suspend fun deleteItem(itemId: Long)

    suspend fun updateItem(item: Long, newName: String)
}