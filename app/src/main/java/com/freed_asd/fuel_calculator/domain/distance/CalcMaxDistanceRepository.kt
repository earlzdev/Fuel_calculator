package com.freed_asd.fuel_calculator.domain.distance

import com.freed_asd.fuel_calculator.data.distance.models.CalcMaxDistanceValuesData
import com.freed_asd.fuel_calculator.data.distance.models.CalcMaxDistanceResultData

interface CalcMaxDistanceRepository {

    fun calcMaxDistance(data: CalcMaxDistanceValuesData) : CalcMaxDistanceResultData
}