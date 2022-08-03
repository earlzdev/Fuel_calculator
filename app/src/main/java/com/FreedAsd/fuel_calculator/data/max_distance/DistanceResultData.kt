package com.FreedAsd.fuel_calculator.data.max_distance

import com.FreedAsd.fuel_calculator.data.max_distance.mappers.ResultDataToDomainMapper

interface DistanceResultData {

    fun <T> map(mapper: ResultDataToDomainMapper<T>) : T

    data class Base(
        private val maxDistance: Int,
        private val tripPrice: Float
    ) : DistanceResultData {
        override fun <T> map(mapper: ResultDataToDomainMapper<T>) =
            mapper.map(maxDistance, tripPrice)
    }
}