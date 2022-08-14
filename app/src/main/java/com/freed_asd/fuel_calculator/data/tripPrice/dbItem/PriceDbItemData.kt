package com.freed_asd.fuel_calculator.data.tripPrice.dbItem

interface PriceDbItemData {

    fun <T> mapToDomain(mapper: PriceDbItemDataMapper<T>) : T

    fun <T> mapToDb(mapper: PriceDbItemDataMapper<T>) : T

    class Base(
        val id: Long,
        val name: String,
        val distance: Float,
        val needFuel: Float,
        val generalPrice: Float,
        var everyonePrice: Float
    ) : PriceDbItemData {

        override fun <T> mapToDomain(mapper: PriceDbItemDataMapper<T>) =
            mapper.mapToDomain(id, name, distance, needFuel, generalPrice, everyonePrice)

        override fun <T> mapToDb(mapper: PriceDbItemDataMapper<T>) =
            mapper.mapToDb(id, name, distance, needFuel, generalPrice, everyonePrice)
    }
}
