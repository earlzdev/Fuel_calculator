package com.freed_asd.fuel_calculator.data.tripPrice.models

interface PriceDbItemData {

    fun <T> mapToDomain(mapper: PriceDbItemDataToDomainMapper<T>) : T

    fun <T> mapToDb(mapper: SavedTripPriceDataToDbMapper<T>) : T

    class Base(
        val id: Long,
        val name: String,
        val distance: Float,
        val needFuel: Float,
        val generalPrice: Float,
        var everyonePrice: Float
    ) : PriceDbItemData {

        override fun <T> mapToDomain(mapper: PriceDbItemDataToDomainMapper<T>) =
            mapper.mapToDomain(id, name, distance, needFuel, generalPrice, everyonePrice)

        override fun <T> mapToDb(mapper: SavedTripPriceDataToDbMapper<T>) =
            mapper.mapToDb(id, name, distance, needFuel, generalPrice, everyonePrice)
    }
}
