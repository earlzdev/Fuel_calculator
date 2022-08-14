package com.freed_asd.fuel_calculator.data.distance.dbItem

interface DistanceDbItemData {

    fun <T> map(mapper: DistanceDbItemDataMapper<T>) : T

    fun <T> mapToDb(mapper: DistanceDbItemMapper<T>) : T

    class Base(
        private val id: Long,
        private val name: String,
        private val distance: Float,
        private val price: Float
    ) : DistanceDbItemData {

        override fun <T> map(mapper: DistanceDbItemDataMapper<T>) = mapper.map(id, name, distance, price)

        override fun <T> mapToDb(mapper: DistanceDbItemMapper<T>) = mapper.map(id, name, distance, price)
    }
}
