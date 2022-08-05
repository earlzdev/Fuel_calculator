package com.FreedAsd.fuel_calculator.data.max_distance


interface DistanceResultData {

    fun <T> map(mapper: Mapper<T>) : T

    data class Base(
        private val maxDistance: Float,
        private val tripPrice: Float
    ) : DistanceResultData {
        override fun <T> map(mapper: Mapper<T>) =
            mapper.map(maxDistance, tripPrice)
    }

    interface Mapper<T> {
        fun map(maxDistance: Float, tripPrice: Float) : T
    }
}