package com.freed_asd.fuel_calculator.domain.tripPrice.dbItem

interface PriceItemDbDomainMapper<T> {

    fun mapToUi(
        id: Long,
        name: String,
        distance: Float,
        needFuel: Float,
        generalPrice: Float,
        everyonePrice: Float
    ) : T

    fun mapToData(
        id: Long,
        name: String,
        distance: Float,
        needFuel: Float,
        generalPrice: Float,
        everyonePrice: Float
    ) : T
}