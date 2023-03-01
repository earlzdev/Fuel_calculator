package com.freed_asd.fuel_calculator.domain.tripPrice.mappers

import com.freed_asd.fuel_calculator.data.tripPrice.models.PriceDbItemDataToDomainMapper
import com.freed_asd.fuel_calculator.domain.tripPrice.models.SavedTripPriceDomain

class BasePriceDbItemDataToDomainMapper : PriceDbItemDataToDomainMapper<SavedTripPriceDomain>{

    override fun mapToDomain(
        id: Long,
        name: String,
        distance: Float,
        needFuel: Float,
        generalPrice: Float,
        everyonePrice: Float
    ) = SavedTripPriceDomain.Base(id, name, distance, needFuel, generalPrice, everyonePrice)
}