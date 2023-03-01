package com.freed_asd.fuel_calculator.data.distance

import com.freed_asd.fuel_calculator.data.distance.models.CalcMaxDistanceResultData
import com.freed_asd.fuel_calculator.data.distance.models.CalcMaxDistanceValuesData
import com.freed_asd.fuel_calculator.domain.distance.CalcMaxDistanceRepository

class CalcMaxDistanceRepositoryImpl(
    private val distanceMapper: CalcMaxDistanceValuesData.MaxDistanceCalculator,
    private val priceMapper: CalcMaxDistanceValuesData.TripPriceCalculator,
) : CalcMaxDistanceRepository {

    override fun calcMaxDistance(data: CalcMaxDistanceValuesData): CalcMaxDistanceResultData {
        return CalcMaxDistanceResultData.Base(
            maxDistance = maxDistance(data),
            tripPrice = tripPrice(data)
        )
    }

    private fun maxDistance(data: CalcMaxDistanceValuesData): Float {
        return data.calculateMaxDistance(distanceMapper)
    }

    private fun tripPrice(data: CalcMaxDistanceValuesData): Float {
        return data.calculateTripPrice(priceMapper)
    }
}