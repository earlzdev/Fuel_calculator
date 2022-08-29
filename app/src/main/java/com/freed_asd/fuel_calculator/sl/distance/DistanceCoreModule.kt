package com.freed_asd.fuel_calculator.sl.distance

import android.content.Context
import com.freed_asd.fuel_calculator.data.distance.CalcMaxDistanceRepositoryImpl
import com.freed_asd.fuel_calculator.data.distance.DistanceInputData
import com.freed_asd.fuel_calculator.data.distance.mappers.BaseInputDomainToDataMapper
import com.freed_asd.fuel_calculator.data.local.AppDataBase
import com.freed_asd.fuel_calculator.domain.distance.interactor.DistanceInteractor
import com.freed_asd.fuel_calculator.domain.distance.mappers.BaseResultDataToDomainMapper
import com.freed_asd.fuel_calculator.sl.CoreModule
import com.freed_asd.fuel_calculator.sl.ResourceProvider

class DistanceCoreModule() {

    lateinit var interactor: DistanceInteractor
    lateinit var resourceProvider: ResourceProvider

    fun init(context: Context) {
        val priceMapper = DistanceInputData.TripPriceMapper.Base()
        val distanceMapper = DistanceInputData.MaxDistanceMapper.Base()
        val distanceRepository = CalcMaxDistanceRepositoryImpl(distanceMapper, priceMapper)
        val distanceInputDomainMapper = BaseInputDomainToDataMapper()
        val distanceResultDomainMapper = BaseResultDataToDomainMapper()
        interactor = DistanceInteractor.Base(distanceRepository, distanceInputDomainMapper, distanceResultDomainMapper)
        val appDb = AppDataBase.localDataBase(context)
        resourceProvider = ResourceProvider.Base(context)
    }
}