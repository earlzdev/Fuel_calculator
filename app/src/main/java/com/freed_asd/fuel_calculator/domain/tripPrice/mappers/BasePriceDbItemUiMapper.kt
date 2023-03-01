package com.freed_asd.fuel_calculator.domain.tripPrice.mappers

import com.freed_asd.fuel_calculator.domain.tripPrice.models.SavedTripPriceDomain
import com.freed_asd.fuel_calculator.presentation.price.dbItem.PriceDbItemUiMapper

class BasePriceDbItemUiMapper: PriceDbItemUiMapper<SavedTripPriceDomain> {

    override fun mapToDomain(
        id: Long,
        name: String,
        distance: Float,
        needFuel: Float,
        generalPrice: Float,
        everyonePrice: Float
    ) = SavedTripPriceDomain.Base(id, name, distance, needFuel, generalPrice, everyonePrice)
}