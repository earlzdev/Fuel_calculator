package com.freed_asd.fuel_calculator.domain.distance.models

import com.freed_asd.fuel_calculator.domain.distance.mappers.ResultDomainToUiMapper

interface CalcMaxDistanceResultDomain {

    fun <T> map(mapper: ResultDomainToUiMapper<T>) : T

    data class Base(
        private val maxDistance: Float,
        private val tripPrice: Float
    ) : CalcMaxDistanceResultDomain {
        override fun <T> map(mapper: ResultDomainToUiMapper<T>) =
            mapper.map(maxDistance, tripPrice)
    }
}