package com.freed_asd.fuel_calculator.domain.consumption.interactor

import android.util.Log
import com.freed_asd.fuel_calculator.data.Repository
import com.freed_asd.fuel_calculator.data.consumption.dbItems.mixed.ConsMixedDataToDomainMapper
import com.freed_asd.fuel_calculator.data.consumption.mappers.BaseConsInputDomainToDataMapper
import com.freed_asd.fuel_calculator.data.local.AppDataBase
import com.freed_asd.fuel_calculator.data.local.consumption.city.ConsCity
import com.freed_asd.fuel_calculator.data.local.consumption.mixed.ConsMixed
import com.freed_asd.fuel_calculator.data.local.consumption.track.ConsTrack
import com.freed_asd.fuel_calculator.domain.consumption.ConsInputDomain
import com.freed_asd.fuel_calculator.domain.consumption.ConsResultDomain
import com.freed_asd.fuel_calculator.domain.consumption.ConsumptionRepository
import com.freed_asd.fuel_calculator.domain.consumption.dbItem.mixed.ConsMixedDbItemDomain
import com.freed_asd.fuel_calculator.domain.consumption.mappers.BaseConsResultDataToDomainMapper
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

interface ConsInteractor : Repository{

    fun calcConsumption(input: ConsInputDomain) : ConsResultDomain

    suspend fun insertValueToDb(driveRegime: String, mileage: Float, consumption: Float)

    fun allMixedDbValues() : Flow<List<ConsMixedDbItemDomain>>

    class Base(
        private val repository: ConsumptionRepository,
        private val inputMapper: BaseConsInputDomainToDataMapper,
        private val resultMapper: BaseConsResultDataToDomainMapper,
        private val mixedDataToDomainMapper: ConsMixedDataToDomainMapper.Base
    ) : ConsInteractor {

        override fun calcConsumption(input: ConsInputDomain) : ConsResultDomain {
            return repository.calcConsumption(input.map(inputMapper)).map(resultMapper)
        }

        override suspend fun insertValueToDb(driveRegime: String, mileage: Float, consumption: Float) {

            when(driveRegime) {
                MIXED -> {
                    val mixed = ConsMixed(0, consumption, mileage)
                    repository.insertIntoMixedDb(mixed)
                }
                CITY -> {
                    val city = ConsCity(0, consumption, mileage)
                    repository.insertIntoCityDb(city)
                }
                TRACK -> {
                    val track = ConsTrack(0, consumption, mileage)
                    repository.insertIntoTrackDb(track)
                }
            }
        }

        override fun allMixedDbValues(): Flow<List<ConsMixedDbItemDomain>> {
            return repository.allDbMixedValues().map { list ->
                list.map { it.mapToDomain(mixedDataToDomainMapper) }
            }
        }
    }

    companion object {

        private const val MIXED = "Смешанный режим езды"
        private const val CITY = "Городской режим езды"
        private const val TRACK = "Трассовый режим езды"
    }
}