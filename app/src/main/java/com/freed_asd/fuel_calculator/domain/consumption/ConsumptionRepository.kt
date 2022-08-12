package com.freed_asd.fuel_calculator.domain.consumption

import com.freed_asd.fuel_calculator.data.consumption.ConsInputData
import com.freed_asd.fuel_calculator.data.consumption.ConsResultData
import com.freed_asd.fuel_calculator.data.local.consumption.city.ConsCity
import com.freed_asd.fuel_calculator.data.local.consumption.mixed.ConsMixed
import com.freed_asd.fuel_calculator.data.local.consumption.track.ConsTrack

interface ConsumptionRepository {

    fun calcConsumption(input: ConsInputData) : ConsResultData

    suspend fun insertIntoMixedDb(value: ConsMixed)

    suspend fun insertIntoTrackDb(value: ConsTrack)

    suspend fun insertIntoCityDb(value: ConsCity)
}