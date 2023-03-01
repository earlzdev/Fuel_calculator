package com.freed_asd.fuel_calculator.presentation.price.dbItem

interface SavedTripPriceUi {

    fun <T> mapToDomain(mapper: PriceDbItemUiMapper<T>) : T

    fun name() : String

    fun id() : Long

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
    ) : SavedTripPriceUi {

        override fun <T> mapToDomain(mapper: PriceDbItemUiMapper<T>) =
            mapper.mapToDomain(id, name, distance, needFuel, generalPrice, everyonePrice)

        override fun name(): String = name

        override fun id(): Long = id

        override fun distance(): Float = distance

        override fun needFuel(): Float = needFuel

        override fun generalPrice(): Float = generalPrice

        override fun everyonePrice(): Float = everyonePrice
    }
}