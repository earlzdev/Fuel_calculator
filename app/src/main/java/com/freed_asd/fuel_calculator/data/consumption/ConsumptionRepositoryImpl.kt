package com.freed_asd.fuel_calculator.data.consumption

import com.freed_asd.fuel_calculator.data.local.AppDataBase
import com.freed_asd.fuel_calculator.data.local.consumption.city.ConsCity
import com.freed_asd.fuel_calculator.data.local.consumption.mixed.ConsMixed
import com.freed_asd.fuel_calculator.data.local.consumption.track.ConsTrack
import com.freed_asd.fuel_calculator.domain.consumption.ConsumptionRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class ConsumptionRepositoryImpl(
    private val appDB: AppDataBase
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
}