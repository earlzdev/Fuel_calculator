package com.freed_asd.fuel_calculator.domain.consumption

import com.freed_asd.fuel_calculator.data.consumption.models.ConsCalcValuesData
import com.freed_asd.fuel_calculator.data.consumption.models.ConsCalcResultData
import com.freed_asd.fuel_calculator.data.consumption.models.SavedCityConsData
import com.freed_asd.fuel_calculator.data.consumption.models.SavedMixedConsData
import com.freed_asd.fuel_calculator.data.consumption.models.SavedTrackConsData
import com.freed_asd.fuel_calculator.data.local.consumption.city.ConsCity
import com.freed_asd.fuel_calculator.data.local.consumption.mixed.ConsMixed
import com.freed_asd.fuel_calculator.data.local.consumption.track.ConsTrack
import kotlinx.coroutines.flow.Flow

interface ConsumptionRepository {

    fun calcConsumption(input: ConsCalcValuesData) : ConsCalcResultData

    suspend fun insertIntoMixedDb(value: ConsMixed)

    suspend fun insertIntoTrackDb(value: ConsTrack)

    suspend fun insertIntoCityDb(value: ConsCity)

    fun allDbMixedValues() : Flow<List<SavedMixedConsData>>

    fun allDbCityValues() : Flow<List<SavedCityConsData>>

    fun allDbTrackValues() : Flow<List<SavedTrackConsData>>

    suspend fun deleteMixedValue(id: Long)

    suspend fun deleteCityValue(id: Long)

    suspend fun deleteTrackValue(id: Long)
}