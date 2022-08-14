package com.freed_asd.fuel_calculator.presentation.distance.dbItem

interface DistanceDbItemUi {

    fun <T> map(mapper: DistanceDbItemUiMapper<T>) : T

    class Base(
        private val id: Long,
        private val name: String,
        private val distance: Float,
        private val price: Float
    ) : DistanceDbItemUi {

        override fun <T> map(mapper: DistanceDbItemUiMapper<T>) = mapper.map(id, name, distance, price)
    }
}