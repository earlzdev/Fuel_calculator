package com.freed_asd.fuel_calculator.domain.consumption.interactor

import android.util.Log
import com.freed_asd.fuel_calculator.data.consumption.mappers.BaseConsInputDomainToDataMapper
import com.freed_asd.fuel_calculator.data.local.AppDataBase
import com.freed_asd.fuel_calculator.data.local.consumption.city.ConsCity
import com.freed_asd.fuel_calculator.data.local.consumption.mixed.ConsMixed
import com.freed_asd.fuel_calculator.data.local.consumption.track.ConsTrack
import com.freed_asd.fuel_calculator.domain.consumption.ConsInputDomain
import com.freed_asd.fuel_calculator.domain.consumption.ConsResultDomain
import com.freed_asd.fuel_calculator.domain.consumption.ConsumptionRepository
import com.freed_asd.fuel_calculator.domain.consumption.mappers.BaseConsResultDataToDomainMapper

interface ConsInteractor {

    fun calcConsumption(input: ConsInputDomain) : ConsResultDomain

    suspend fun insertValueToDb(driveRegime: String, mileage: Float, consumption: Float)

    class Base(
        private val repository: ConsumptionRepository,
        private val inputMapper: BaseConsInputDomainToDataMapper,
        private val resultMapper: BaseConsResultDataToDomainMapper
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

    }

    companion object {

        private const val MIXED = "Смешанный режим езды"
        private const val CITY = "Городской режим езды"
        private const val TRACK = "Трассовый режим езды"
    }
}