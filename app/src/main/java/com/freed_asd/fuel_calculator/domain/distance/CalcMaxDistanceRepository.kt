package com.freed_asd.fuel_calculator.domain.distance

import com.freed_asd.fuel_calculator.data.distance.DistanceInputData
import com.freed_asd.fuel_calculator.data.distance.DistanceResultData
import com.freed_asd.fuel_calculator.data.local.distance.DistanceDb

interface CalcMaxDistanceRepository {

    fun calcMaxDistance(data: DistanceInputData) : DistanceResultData

    suspend fun insertIntoDb(value: DistanceDb)
}