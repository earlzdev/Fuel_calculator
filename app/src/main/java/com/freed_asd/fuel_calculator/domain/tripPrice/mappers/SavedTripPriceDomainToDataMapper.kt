package com.freed_asd.fuel_calculator.domain.tripPrice.mappers

interface SavedTripPriceDomainToDataMapper<T> {

    fun map(
        id: Long,
        name: String,
        distance: Float,
        needFuel: Float,
        generalPrice: Float,
        everyonePrice: Float
    ) : T
}