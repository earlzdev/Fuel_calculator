package com.freed_asd.fuel_calculator.presentation.price.dbItem

interface PriceDbItemUi {

    fun <T> mapToDomain(mapper: PriceDbItemUiMapper<T>) : T

    class Base(
        val id: Long,
        val name: String,
        val distance: Float,
        val needFuel: Float,
        val generalPrice: Float,
        var everyonePrice: Float
    ) : PriceDbItemUi {

        override fun <T> mapToDomain(mapper: PriceDbItemUiMapper<T>) =
            mapper.mapToDomain(id, name, distance, needFuel, generalPrice, everyonePrice)
    }
}