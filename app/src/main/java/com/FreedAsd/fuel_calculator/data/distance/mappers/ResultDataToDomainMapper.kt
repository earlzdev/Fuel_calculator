package com.FreedAsd.fuel_calculator.data.distance.mappers

interface ResultDataToDomainMapper<T> {

    fun map(maxDistance: Float, tripPrice: Float) : T
}