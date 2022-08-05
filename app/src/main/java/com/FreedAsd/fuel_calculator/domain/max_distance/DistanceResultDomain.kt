package com.FreedAsd.fuel_calculator.domain.max_distance

interface DistanceResultDomain {

    data class Base(
        private val maxDistance: Float,
        private val tripPrice: Float
    ) : DistanceResultDomain
}