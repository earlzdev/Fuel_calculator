package com.freed_asd.fuel_calculator.data.distance

import com.freed_asd.fuel_calculator.data.distance.dbItem.DistanceDbItemData
import com.freed_asd.fuel_calculator.data.distance.dbItem.DistanceDbItemMapper
import com.freed_asd.fuel_calculator.data.local.AppDataBase
import com.freed_asd.fuel_calculator.data.local.distance.DistanceDb
import com.freed_asd.fuel_calculator.domain.distance.CalcMaxDistanceRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class CalcMaxDistanceRepositoryImpl(
    private val appDB: AppDataBase,
    private val distanceMapper: DistanceInputData.MaxDistanceMapper,
    private val priceMapper: DistanceInputData.TripPriceMapper,
    private val dbDataMapper: DistanceDbItemMapper<DistanceDb>
) : CalcMaxDistanceRepository {

    override fun calcMaxDistance(data: DistanceInputData): DistanceResultData {
        return DistanceResultData.Base(
            maxDistance = maxDistance(data),
            tripPrice = tripPrice(data)
        )
    }

    private fun maxDistance(data: DistanceInputData): Float {
        return data.maxDistance(distanceMapper)
    }

    private fun tripPrice(data: DistanceInputData): Float {
        return data.tripPrice(priceMapper)
    }

    override suspend fun insertIntoDb(value: DistanceDbItemData) {
        GlobalScope.launch(Dispatchers.IO) {
            appDB.distanceDao().insertValue(value.mapToDb(dbDataMapper))
        }
    }
}