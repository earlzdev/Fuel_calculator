package com.freed_asd.fuel_calculator.domain.consumption.interactor

import com.freed_asd.fuel_calculator.data.Repository
import com.freed_asd.fuel_calculator.data.consumption.dbItems.city.ConsCityDataToDomainMapper
import com.freed_asd.fuel_calculator.data.consumption.dbItems.mixed.ConsMixedDataToDomainMapper
import com.freed_asd.fuel_calculator.data.consumption.dbItems.track.ConsTrackDataToDomainMapper
import com.freed_asd.fuel_calculator.data.consumption.mappers.BaseConsInputDomainToDataMapper
import com.freed_asd.fuel_calculator.data.local.consumption.city.ConsCity
import com.freed_asd.fuel_calculator.data.local.consumption.mixed.ConsMixed
import com.freed_asd.fuel_calculator.data.local.consumption.track.ConsTrack
import com.freed_asd.fuel_calculator.domain.consumption.ConsInputDomain
import com.freed_asd.fuel_calculator.domain.consumption.ConsResultDomain
import com.freed_asd.fuel_calculator.domain.consumption.ConsumptionRepository
import com.freed_asd.fuel_calculator.domain.consumption.dbItem.city.ConsCityDbItemDomain
import com.freed_asd.fuel_calculator.domain.consumption.dbItem.mixed.ConsMixedDbItemDomain
import com.freed_asd.fuel_calculator.domain.consumption.dbItem.track.ConsTrackDbItemDomain
import com.freed_asd.fuel_calculator.domain.consumption.mappers.BaseConsResultDataToDomainMapper
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

interface ConsInteractor : Repository{

    fun calcConsumption(input: ConsInputDomain) : ConsResultDomain

    suspend fun insertValueToDb(driveRegime: String, mileage: Float, consumption: Float)

    fun allMixedDbValues() : Flow<List<ConsMixedDbItemDomain>>

    fun allCityDbValues() : Flow<List<ConsCityDbItemDomain>>

    fun allTrackDbValues() : Flow<List<ConsTrackDbItemDomain>>

    suspend fun deleteMixedValue(id: Long)

    suspend fun deleteCityValue(id: Long)

    suspend fun deleteTrackValue(id: Long)

    class Base(
        private val repository: ConsumptionRepository,
        private val inputMapper: BaseConsInputDomainToDataMapper,
        private val resultMapper: BaseConsResultDataToDomainMapper,
        private val mixedDataToDomainMapper: ConsMixedDataToDomainMapper.Base,
        private val cityDataToDomainMapper: ConsCityDataToDomainMapper.Base,
        private val trackDataToDomainMapper: ConsTrackDataToDomainMapper.Base
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

        override fun allCityDbValues(): Flow<List<ConsCityDbItemDomain>> {
            return repository.allDbCityValues().map { list ->
                list.map { it.mapToDomain(cityDataToDomainMapper) }
            }
        }

        override fun allTrackDbValues(): Flow<List<ConsTrackDbItemDomain>> {
            return repository.allDbTrackValues().map { list ->
                list.map { it.mapToDomain(trackDataToDomainMapper) }
            }
        }

        override suspend fun deleteMixedValue(id: Long) {
            repository.deleteMixedValue(id)
        }

        override suspend fun deleteCityValue(id: Long) {
            repository.deleteCityValue(id)
        }

        override suspend fun deleteTrackValue(id: Long) {
            repository.deleteTrackValue(id)
        }
    }

    companion object {

        private const val MIXED = "Смешанный режим езды"
        private const val CITY = "Городской режим езды"
        private const val TRACK = "Трассовый режим езды"
    }
}