package com.freed_asd.fuel_calculator.data.distance.models

import com.freed_asd.fuel_calculator.data.distance.mappers.ResultDataToDomainMapper

interface CalcMaxDistanceResultData {

    fun <T> map(mapper: ResultDataToDomainMapper<T>) : T

    data class Base(
        private val maxDistance: Float,
        private val tripPrice: Float
    ) : CalcMaxDistanceResultData {

        override fun <T> map(mapper: ResultDataToDomainMapper<T>) =
            mapper.map(maxDistance, tripPrice)
    }
}