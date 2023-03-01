package com.freed_asd.fuel_calculator.data.local.mappers

import com.freed_asd.fuel_calculator.data.local.price.PriceDb
import com.freed_asd.fuel_calculator.data.tripPrice.models.SavedTripPriceDataToDbMapper

class BaseSavedTripPriceDataToDbMapper :
    SavedTripPriceDataToDbMapper<PriceDb> {

    override fun mapToDb(
        id: Long,
        name: String,
        distance: Float,
        needFuel: Float,
        generalPrice: Float,
        everyonePrice: Float
    ) = PriceDb(id, name, distance, needFuel, generalPrice, everyonePrice)
}