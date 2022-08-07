package com.freedasd.fuel_calculator.domain.distance.mappers

interface ResultDomainToUiMapper<T> {

    fun map(maxDistance: Float, tripPrice: Float) : T
}