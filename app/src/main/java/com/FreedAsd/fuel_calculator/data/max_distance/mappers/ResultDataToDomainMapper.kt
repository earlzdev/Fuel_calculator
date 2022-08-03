package com.FreedAsd.fuel_calculator.data.max_distance.mappers

interface ResultDataToDomainMapper<T> {

    fun map(maxDistance: Int, tripPrice: Float) : T
}