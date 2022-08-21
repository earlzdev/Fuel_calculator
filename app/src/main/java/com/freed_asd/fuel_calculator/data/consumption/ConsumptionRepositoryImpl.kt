package com.freed_asd.fuel_calculator.data.consumption

import com.freed_asd.fuel_calculator.data.consumption.dbItems.city.ConsCityDbItemData
import com.freed_asd.fuel_calculator.data.consumption.dbItems.city.ConsCityDbToDataMapper
import com.freed_asd.fuel_calculator.data.consumption.dbItems.mixed.ConsMixedDbItemData
import com.freed_asd.fuel_calculator.data.consumption.dbItems.mixed.ConsMixedDbToDataMapper
import com.freed_asd.fuel_calculator.data.consumption.dbItems.track.ConsTrackDbItemData
import com.freed_asd.fuel_calculator.data.consumption.dbItems.track.ConsTrackDbToDataMapper
import com.freed_asd.fuel_calculator.data.local.AppDataBase
import com.freed_asd.fuel_calculator.data.local.consumption.city.ConsCity
import com.freed_asd.fuel_calculator.data.local.consumption.mixed.ConsMixed
import com.freed_asd.fuel_calculator.data.local.consumption.track.ConsTrack
import com.freed_asd.fuel_calculator.domain.consumption.ConsumptionRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.launch

class ConsumptionRepositoryImpl(
    private val appDB: AppDataBase,
    private val mixedDbToDataMapper: ConsMixedDbToDataMapper.Base,
    private val cityDbToDataMapper: ConsCityDbToDataMapper.Base,
    private val trackDbToDataMapper: ConsTrackDbToDataMapper.Base
) : ConsumptionRepository {

    override fun calcConsumption(input: ConsInputData): ConsResultData {
        return ConsResultData.Base(
            consumption = input.consumption()
        )
    }

    override suspend fun insertIntoMixedDb(value: ConsMixed) {
        GlobalScope.launch(Dispatchers.IO) {
            appDB.mixedDao().insertValue(value)
        }
    }

    override suspend fun insertIntoTrackDb(value: ConsTrack) {
        GlobalScope.launch(Dispatchers.IO) {
            appDB.trackDao().insertValue(value)
        }
    }

    override suspend fun insertIntoCityDb(value: ConsCity) {
        GlobalScope.launch(Dispatchers.IO) {
            appDB.cityDao().insertValue(value)
        }
    }

    override fun allDbMixedValues(): Flow<List<ConsMixedDbItemData>> =
        appDB.mixedDao().allValues().map { list ->
            list.map { mixedDbToDataMapper.mapToData(it) }
    }

    override fun allDbCityValues(): Flow<List<ConsCityDbItemData>> =
        appDB.cityDao().allValues().map { list ->
            list.map { cityDbToDataMapper.mapToData(it) }
        }

    override fun allDbTrackValues(): Flow<List<ConsTrackDbItemData>> =
        appDB.trackDao().allValues().map { list ->
            list.map { trackDbToDataMapper.mapToData(it) }
        }
}