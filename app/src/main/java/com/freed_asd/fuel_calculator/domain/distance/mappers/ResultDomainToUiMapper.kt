package com.freed_asd.fuel_calculator.domain.distance.mappers

interface ResultDomainToUiMapper<T> {

    fun map(maxDistance: Float, tripPrice: Float) : T
}