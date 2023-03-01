package com.freed_asd.fuel_calculator.domain.consumption

import com.freed_asd.fuel_calculator.data.consumption.mappers.BaseConsInputDomainToDataMapper
import com.freed_asd.fuel_calculator.data.consumption.mappers.ConsCityDataToDomainMapper
import com.freed_asd.fuel_calculator.data.consumption.mappers.ConsMixedDataToDomainMapper
import com.freed_asd.fuel_calculator.data.consumption.mappers.ConsTrackDataToDomainMapper
import com.freed_asd.fuel_calculator.data.local.consumption.city.ConsCity
import com.freed_asd.fuel_calculator.data.local.consumption.mixed.ConsMixed
import com.freed_asd.fuel_calculator.data.local.consumption.track.ConsTrack
import com.freed_asd.fuel_calculator.domain.consumption.mappers.BaseConsResultDataToDomainMapper
import com.freed_asd.fuel_calculator.domain.consumption.models.*
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

interface ConsInteractor {

    fun calcConsumption(input: ConsCalcValuesDomain) : ConsCalcResultDomain

    suspend fun insertValueToDb(driveRegime: String, mileage: Float, consumption: Float)

    fun allMixedDbValues() : Flow<List<SavedMixedDomain>>

    fun allCityDbValues() : Flow<List<SavedCityConsDomain>>

    fun allTrackDbValues() : Flow<List<SavedTrackConsDomain>>

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

        override fun calcConsumption(input: ConsCalcValuesDomain) : ConsCalcResultDomain {
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

        override fun allMixedDbValues(): Flow<List<SavedMixedDomain>> {
            return repository.allDbMixedValues().map { list ->
                list.map { it.mapToDomain(mixedDataToDomainMapper) }
            }
        }

        override fun allCityDbValues(): Flow<List<SavedCityConsDomain>> {
            return repository.allDbCityValues().map { list ->
                list.map { it.mapToDomain(cityDataToDomainMapper) }
            }
        }

        override fun allTrackDbValues(): Flow<List<SavedTrackConsDomain>> {
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