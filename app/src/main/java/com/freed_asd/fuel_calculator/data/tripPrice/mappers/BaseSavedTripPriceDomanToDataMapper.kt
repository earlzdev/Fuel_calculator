package com.freed_asd.fuel_calculator.data.tripPrice.mappers

import com.freed_asd.fuel_calculator.data.tripPrice.models.PriceDbItemData
import com.freed_asd.fuel_calculator.domain.tripPrice.mappers.SavedTripPriceDomainToDataMapper

class BaseSavedTripPriceDomainToDataMapper : SavedTripPriceDomainToDataMapper<PriceDbItemData> {

    override fun map(
        id: Long,
        name: String,
        distance: Float,
        needFuel: Float,
        generalPrice: Float,
        everyonePrice: Float
    ) = PriceDbItemData.Base(id, name, distance, needFuel, generalPrice, everyonePrice)
}