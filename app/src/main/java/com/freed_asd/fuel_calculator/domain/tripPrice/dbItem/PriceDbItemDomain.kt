package com.freed_asd.fuel_calculator.domain.tripPrice.dbItem

interface PriceDbItemDomain {

    fun <T> mapToUi(mapper: PriceItemDbDomainMapper<T>) : T

    fun <T> mapToData(mapper: PriceItemDbDomainMapper<T>) : T

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
    ) : PriceDbItemDomain {

        override fun <T> mapToUi(mapper: PriceItemDbDomainMapper<T>) =
            mapper.mapToUi(id, name, distance, needFuel, generalPrice, everyonePrice)

        override fun <T> mapToData(mapper: PriceItemDbDomainMapper<T>) =
            mapper.mapToData(id, name, distance, needFuel, generalPrice, everyonePrice)

        override fun id(): Long = id

        override fun name(): String = name

        override fun distance() = distance

        override fun needFuel() = needFuel

        override fun generalPrice() = generalPrice

        override fun everyonePrice() = everyonePrice
    }
}