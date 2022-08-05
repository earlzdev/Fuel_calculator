package com.FreedAsd.fuel_calculator.data.max_distance

import com.FreedAsd.fuel_calculator.domain.max_distance.CalcMaxDistanceRepository

class CalcMaxDistanceRepositoryImpl(
    private val distanceMapper: DistanceInputData.MaxDistanceMapper,
    private val priceMapper: DistanceInputData.TripPriceMapper
) : CalcMaxDistanceRepository {

    override fun calcMaxDistance(data: DistanceInputData): DistanceResultData {
        return DistanceResultData.Base(
            maxDistance = maxDistance(data),
            tripPrice = tripPrice(data)
        )
    }

    private fun maxDistance(data: DistanceInputData): Float {
        return data.maxDistance(distanceMapper)
    }

    private fun tripPrice(data: DistanceInputData): Float {
        return data.tripPrice(priceMapper)
    }
}