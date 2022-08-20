package com.freed_asd.fuel_calculator.data.tripPrice.dbItem

interface PriceDbItemDataMapper<T> {

//    fun mapToDomain(
//        id: Long,
//        name: String,
//        distance: Float,
//        needFuel: Float,
//        generalPrice: Float,
//        everyonePrice: Float
//    ) : T

    fun mapToDb(
        id: Long,
        name: String,
        distance: Float,
        needFuel: Float,
        generalPrice: Float,
        everyonePrice: Float
    ) : T
}