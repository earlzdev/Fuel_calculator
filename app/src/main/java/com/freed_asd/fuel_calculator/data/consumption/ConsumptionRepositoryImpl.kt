package com.freed_asd.fuel_calculator.data.consumption

import com.freed_asd.fuel_calculator.data.consumption.mappers.ConsCityDbToDataMapper
import com.freed_asd.fuel_calculator.data.consumption.mappers.ConsMixedDbToDataMapper
import com.freed_asd.fuel_calculator.data.consumption.mappers.ConsTrackDbToDataMapper
import com.freed_asd.fuel_calculator.data.consumption.models.*
import com.freed_asd.fuel_calculator.data.local.AppDataBase
import com.freed_asd.fuel_calculator.data.local.consumption.city.ConsCity
import com.freed_asd.fuel_calculator.data.local.consumption.mixed.ConsMixed
import com.freed_asd.fuel_calculator.data.local.consumption.track.ConsTrack
import com.freed_asd.fuel_calculator.domain.consumption.ConsumptionRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class ConsumptionRepositoryImpl(
    private val appDB: AppDataBase,
    private val mixedDbToDataMapper: ConsMixedDbToDataMapper.Base,
    private val cityDbToDataMapper: ConsCityDbToDataMapper.Base,
    private val trackDbToDataMapper: ConsTrackDbToDataMapper.Base
) : ConsumptionRepository {

    override fun calcConsumption(input: ConsCalcValuesData): ConsCalcResultData {
        return ConsCalcResultData.Base(
            consumption = input.calculateConsumption()
        )
    }

    override suspend fun insertIntoMixedDb(value: ConsMixed) {
        appDB.mixedDao().insertValue(value)
    }

    override suspend fun insertIntoTrackDb(value: ConsTrack) {
        appDB.trackDao().insertValue(value)
    }

    override suspend fun insertIntoCityDb(value: ConsCity) {
        appDB.cityDao().insertValue(value)
    }

    override fun allDbMixedValues(): Flow<List<SavedMixedConsData>> =
        appDB.mixedDao().allValues().map { list ->
            list.map { mixedDbToDataMapper.mapToData(it) }
        }

    override fun allDbCityValues(): Flow<List<SavedCityConsData>> =
        appDB.cityDao().allValues().map { list ->
            list.map { cityDbToDataMapper.mapToData(it) }
        }

    override fun allDbTrackValues(): Flow<List<SavedTrackConsData>> =
        appDB.trackDao().allValues().map { list ->
            list.map { trackDbToDataMapper.mapToData(it) }
        }

    override suspend fun deleteMixedValue(id: Long) {
        appDB.mixedDao().deleteValue(id)
    }

    override suspend fun deleteCityValue(id: Long) {
        appDB.cityDao().deleteValue(id)
    }

    override suspend fun deleteTrackValue(id: Long) {
        appDB.trackDao().deleteValue(id)
    }
}