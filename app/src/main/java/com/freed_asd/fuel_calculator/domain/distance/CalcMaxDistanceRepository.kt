package com.freed_asd.fuel_calculator.domain.distance

import com.freed_asd.fuel_calculator.data.distance.DistanceInputData
import com.freed_asd.fuel_calculator.data.distance.DistanceResultData

interface CalcMaxDistanceRepository {

    fun calcMaxDistance(data: DistanceInputData) : DistanceResultData
}