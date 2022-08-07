package com.FreedAsd.fuel_calculator.data.distance

import com.FreedAsd.fuel_calculator.data.distance.mappers.ResultDataToDomainMapper

interface DistanceResultData {

    fun <T> map(mapper: ResultDataToDomainMapper<T>) : T

    data class Base(
        private val maxDistance: Float,
        private val tripPrice: Float
    ) : DistanceResultData {
        override fun <T> map(mapper: ResultDataToDomainMapper<T>) =
            mapper.map(maxDistance, tripPrice)
    }
}