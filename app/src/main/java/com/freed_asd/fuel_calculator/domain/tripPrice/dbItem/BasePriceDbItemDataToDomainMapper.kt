package com.freed_asd.fuel_calculator.domain.tripPrice.dbItem

import com.freed_asd.fuel_calculator.data.tripPrice.dbItem.PriceDbItemData
import com.freed_asd.fuel_calculator.data.tripPrice.dbItem.PriceDbItemDataToDomainMapper

class BasePriceDbItemDataToDomainMapper : PriceDbItemDataToDomainMapper<PriceDbItemDomain>{

    override fun mapToDomain(
        id: Long,
        name: String,
        distance: Float,
        needFuel: Float,
        generalPrice: Float,
        everyonePrice: Float
    ) = PriceDbItemDomain.Base(id, name, distance, needFuel, generalPrice, everyonePrice)
}