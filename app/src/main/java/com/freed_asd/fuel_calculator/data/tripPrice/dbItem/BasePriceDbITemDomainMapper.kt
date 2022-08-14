package com.freed_asd.fuel_calculator.data.tripPrice.dbItem

import com.freed_asd.fuel_calculator.domain.tripPrice.dbItem.PriceItemDbDomainMapper

class BasePriceDbITemDomainMapper: PriceItemDbDomainMapper<PriceDbItemData> {

    override fun mapToUi(
        id: Long,
        name: String,
        distance: Float,
        needFuel: Float,
        generalPrice: Float,
        everyonePrice: Float
    ): PriceDbItemData {
        TODO("Not yet implemented")
    }

    override fun mapToData(
        id: Long,
        name: String,
        distance: Float,
        needFuel: Float,
        generalPrice: Float,
        everyonePrice: Float
    ) = PriceDbItemData.Base(id, name, distance, needFuel, generalPrice, everyonePrice)
}