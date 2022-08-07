package com.freedasd.fuel_calculator.domain.distance

import com.freedasd.fuel_calculator.data.distance.DistanceInputData
import com.freedasd.fuel_calculator.data.distance.DistanceResultData

interface CalcMaxDistanceRepository {

    fun calcMaxDistance(data: DistanceInputData) : DistanceResultData
}