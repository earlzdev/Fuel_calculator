package com.freed_asd.fuel_calculator.domain.distance

import com.freed_asd.fuel_calculator.domain.distance.mappers.ResultDomainToUiMapper

interface DistanceResultDomain {

    fun <T> map(mapper: ResultDomainToUiMapper<T>) : T

    data class Base(
        private val maxDistance: Float,
        private val tripPrice: Float
    ) : DistanceResultDomain {
        override fun <T> map(mapper: ResultDomainToUiMapper<T>) =
            mapper.map(maxDistance, tripPrice)
    }
}