package com.freed_asd.fuel_calculator.data.tripPrice.models

interface SavedTripPriceDataToDbMapper<T> {

    fun mapToDb(
        id: Long,
        name: String,
        distance: Float,
        needFuel: Float,
        generalPrice: Float,
        everyonePrice: Float
    ) : T
}