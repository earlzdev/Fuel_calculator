package com.freed_asd.fuel_calculator.data.consumption.models

import com.freed_asd.fuel_calculator.data.consumption.mappers.ConsTrackDataToDbMapper
import com.freed_asd.fuel_calculator.data.consumption.mappers.ConsTrackDataToDomainMapper

interface SavedTrackConsData {

    fun<T> mapToDb(mapper: ConsTrackDataToDbMapper<T>) : T

    fun<T> mapToDomain(mapper: ConsTrackDataToDomainMapper<T>) : T

    class Base(
        private val id: Long,
        private val consumption: Float,
        private val mileage: Float
    ) : SavedTrackConsData {

        override fun <T> mapToDb(mapper: ConsTrackDataToDbMapper<T>) = mapper.mapToDb(id, consumption, mileage)

        override fun <T> mapToDomain(mapper: ConsTrackDataToDomainMapper<T>) = mapper.mapToDomain(id, consumption, mileage)
    }
}