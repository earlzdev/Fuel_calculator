package com.freed_asd.fuel_calculator.presentation.price.dbItem

import com.freed_asd.fuel_calculator.domain.tripPrice.models.PriceItemDbDomainMapper

class BasePriceDbItemDomainMapperUi: PriceItemDbDomainMapper<SavedTripPriceUi> {

    override fun mapToUi(
        id: Long,
        name: String,
        distance: Float,
        needFuel: Float,
        generalPrice: Float,
        everyonePrice: Float
    ) = SavedTripPriceUi.Base(id, name, distance, needFuel, generalPrice, everyonePrice)

    override fun mapToData(
        id: Long,
        name: String,
        distance: Float,
        needFuel: Float,
        generalPrice: Float,
        everyonePrice: Float
    ): SavedTripPriceUi {
        TODO("Not yet implemented")
    }
}