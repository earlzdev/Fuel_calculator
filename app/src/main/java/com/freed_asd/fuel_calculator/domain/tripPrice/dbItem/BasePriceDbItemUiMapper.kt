package com.freed_asd.fuel_calculator.domain.tripPrice.dbItem

import com.freed_asd.fuel_calculator.presentation.price.dbItem.PriceDbItemUiMapper

class BasePriceDbItemUiMapper: PriceDbItemUiMapper<PriceDbItemDomain> {

    override fun mapToDomain(
        id: Long,
        name: String,
        distance: Float,
        needFuel: Float,
        generalPrice: Float,
        everyonePrice: Float
    ) = PriceDbItemDomain.Base(id, name, distance, needFuel, generalPrice, everyonePrice)
}