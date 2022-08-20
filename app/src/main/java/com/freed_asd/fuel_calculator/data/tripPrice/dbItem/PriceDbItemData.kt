package com.freed_asd.fuel_calculator.data.tripPrice.dbItem

interface PriceDbItemData {

    fun <T> mapToDomain(mapper: PriceDbItemDataToDomainMapper<T>) : T

    fun <T> mapToDb(mapper: PriceDbItemDataMapper<T>) : T

    fun id() : Long

    fun name() : String

    fun distance() : Float

    fun needFuel() : Float

    fun generalPrice() : Float

    fun everyonePrice() : Float

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

        override fun <T> mapToDb(mapper: PriceDbItemDataMapper<T>) =
            mapper.mapToDb(id, name, distance, needFuel, generalPrice, everyonePrice)

        override fun id(): Long = id

        override fun name(): String = name

        override fun distance() = distance

        override fun needFuel() = needFuel

        override fun generalPrice() = generalPrice

        override fun everyonePrice() = everyonePrice
    }
}
