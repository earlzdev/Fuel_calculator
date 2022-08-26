package com.freed_asd.fuel_calculator.domain.consumption

import com.freed_asd.fuel_calculator.data.consumption.ConsInputData
import com.freed_asd.fuel_calculator.data.consumption.ConsResultData
import com.freed_asd.fuel_calculator.data.consumption.dbItems.city.ConsCityDbItemData
import com.freed_asd.fuel_calculator.data.consumption.dbItems.mixed.ConsMixedDbItemData
import com.freed_asd.fuel_calculator.data.consumption.dbItems.track.ConsTrackDbItemData
import com.freed_asd.fuel_calculator.data.local.consumption.city.ConsCity
import com.freed_asd.fuel_calculator.data.local.consumption.mixed.ConsMixed
import com.freed_asd.fuel_calculator.data.local.consumption.track.ConsTrack
import kotlinx.coroutines.flow.Flow

interface ConsumptionRepository {

    fun calcConsumption(input: ConsInputData) : ConsResultData

    suspend fun insertIntoMixedDb(value: ConsMixed)

    suspend fun insertIntoTrackDb(value: ConsTrack)

    suspend fun insertIntoCityDb(value: ConsCity)

    fun allDbMixedValues() : Flow<List<ConsMixedDbItemData>>

    fun allDbCityValues() : Flow<List<ConsCityDbItemData>>

    fun allDbTrackValues() : Flow<List<ConsTrackDbItemData>>

    suspend fun deleteMixedValue(id: Long)

    suspend fun deleteCityValue(id: Long)

    suspend fun deleteTrackValue(id: Long)
}