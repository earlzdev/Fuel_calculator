package com.freed_asd.fuel_calculator.data.tripPrice.dbItem

import com.freed_asd.fuel_calculator.data.local.price.PriceDb

interface PriceDbToDataItemMapper<T> {

    fun mapToData(item: PriceDb) : T
}

class BasePriceDbToDataItemMapper : PriceDbToDataItemMapper<PriceDbItemData> {

    override fun mapToData(item: PriceDb): PriceDbItemData = PriceDbItemData.Base(item.id, item.name, item.distance, item.needFuel, item.generalPrice, item.everyonePrice)
}