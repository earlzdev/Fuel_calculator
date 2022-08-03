package com.FreedAsd.fuel_calculator.domain.max_distance

import com.FreedAsd.fuel_calculator.data.max_distance.DistanceInputData
import com.FreedAsd.fuel_calculator.data.max_distance.DistanceResultData

interface CalcMaxDistanceRepository {

    fun calcMaxDistance(data: DistanceInputData) : DistanceResultData
}