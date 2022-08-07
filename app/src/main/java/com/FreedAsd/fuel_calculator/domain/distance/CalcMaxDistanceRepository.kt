package com.FreedAsd.fuel_calculator.domain.distance

import com.FreedAsd.fuel_calculator.data.distance.DistanceInputData
import com.FreedAsd.fuel_calculator.data.distance.DistanceResultData

interface CalcMaxDistanceRepository {

    fun calcMaxDistance(data: DistanceInputData) : DistanceResultData
}