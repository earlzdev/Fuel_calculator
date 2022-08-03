package com.FreedAsd.fuel_calculator.domain.max_distance

interface DistanceResultDomain {

    data class Base(
        private val maxDistance: Int,
        private val tripPrice: Float
    ) : DistanceResultDomain
}