package com.freed_asd.fuel_calculator.presentation.price.dbItem

interface PriceDbItemUiMapper<T> {

    fun mapToDomain(
        id: Long,
        name: String,
        distance: Float,
        needFuel: Float,
        generalPrice: Float,
        everyonePrice: Float
    ) : T
}