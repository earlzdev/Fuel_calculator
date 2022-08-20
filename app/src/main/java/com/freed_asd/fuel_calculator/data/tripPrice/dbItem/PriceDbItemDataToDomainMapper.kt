package com.freed_asd.fuel_calculator.data.tripPrice.dbItem

interface PriceDbItemDataToDomainMapper<T> {

    fun mapToDomain(id: Long,
                    name: String,
                    distance: Float,
                    needFuel: Float,
                    generalPrice: Float,
                    everyonePrice: Float) : T


}