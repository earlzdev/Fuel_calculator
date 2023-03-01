package com.freed_asd.fuel_calculator.sl.consumption

import android.content.Context
import com.freed_asd.fuel_calculator.data.consumption.ConsumptionRepositoryImpl
import com.freed_asd.fuel_calculator.data.consumption.mappers.*
import com.freed_asd.fuel_calculator.data.local.AppDataBase
import com.freed_asd.fuel_calculator.domain.consumption.ConsInteractor
import com.freed_asd.fuel_calculator.domain.consumption.mappers.BaseConsResultDataToDomainMapper
import com.freed_asd.fuel_calculator.sl.ResourceProvider

class ConsCoreModule {

    lateinit var interactor: ConsInteractor
    lateinit var resourceProvider: ResourceProvider

    fun init(context: Context) {
        val appDb = AppDataBase.localDataBase(context)
        val trackDbToDataMapper = ConsTrackDbToDataMapper.Base()
        val trackDataToDomainMapper = ConsTrackDataToDomainMapper.Base()
        val cityDbToDataMapper = ConsCityDbToDataMapper.Base()
        val consMixedDbToDataMapper = ConsMixedDbToDataMapper.Base()
        val consRepository = ConsumptionRepositoryImpl(appDb, consMixedDbToDataMapper, cityDbToDataMapper, trackDbToDataMapper)
        val inputConsInteractorMapper = BaseConsInputDomainToDataMapper()
        val resultConsInteractorMapper = BaseConsResultDataToDomainMapper()
        val mixedDataToDomainMapper = ConsMixedDataToDomainMapper.Base()
        val cityDataToDomainMapper = ConsCityDataToDomainMapper.Base()
        resourceProvider = ResourceProvider.Base(context)
        interactor = ConsInteractor.Base(consRepository, inputConsInteractorMapper, resultConsInteractorMapper, mixedDataToDomainMapper, cityDataToDomainMapper, trackDataToDomainMapper)
    }
}