package com.freed_asd.fuel_calculator.sl.distance

import android.content.Context
import com.freed_asd.fuel_calculator.data.distance.CalcMaxDistanceRepositoryImpl
import com.freed_asd.fuel_calculator.data.distance.models.CalcMaxDistanceValuesData
import com.freed_asd.fuel_calculator.data.distance.mappers.BaseInputDomainToDataMapper
import com.freed_asd.fuel_calculator.data.local.AppDataBase
import com.freed_asd.fuel_calculator.domain.distance.DistanceInteractor
import com.freed_asd.fuel_calculator.domain.distance.mappers.BaseResultDataToDomainMapper
import com.freed_asd.fuel_calculator.sl.ResourceProvider

class DistanceCoreModule {

    lateinit var interactor: DistanceInteractor
    lateinit var resourceProvider: ResourceProvider

    fun init(context: Context) {
        val priceMapper = CalcMaxDistanceValuesData.TripPriceCalculator.Base()
        val distanceMapper = CalcMaxDistanceValuesData.MaxDistanceCalculator.Base()
        val distanceRepository = CalcMaxDistanceRepositoryImpl(distanceMapper, priceMapper)
        val distanceInputDomainMapper = BaseInputDomainToDataMapper()
        val distanceResultDomainMapper = BaseResultDataToDomainMapper()
        interactor = DistanceInteractor.Base(distanceRepository, distanceInputDomainMapper, distanceResultDomainMapper)
        val appDb = AppDataBase.localDataBase(context)
        resourceProvider = ResourceProvider.Base(context)
    }
}