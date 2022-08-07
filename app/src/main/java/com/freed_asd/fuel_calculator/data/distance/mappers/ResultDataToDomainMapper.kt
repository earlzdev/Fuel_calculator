package com.freed_asd.fuel_calculator.data.distance.mappers

interface ResultDataToDomainMapper<T> {

    fun map(maxDistance: Float, tripPrice: Float) : T
}