package com.freed_asd.fuel_calculator.data.local.price

import com.freed_asd.fuel_calculator.data.tripPrice.dbItem.PriceDbItemDataMapper

class BasePriceItemDbMapper : PriceDbItemDataMapper<PriceDb> {

    override fun mapToDb(
        id: Long,
        name: String,
        distance: Float,
        needFuel: Float,
        generalPrice: Float,
        everyonePrice: Float
    ) = PriceDb(id, name, distance, needFuel, generalPrice, everyonePrice)
}