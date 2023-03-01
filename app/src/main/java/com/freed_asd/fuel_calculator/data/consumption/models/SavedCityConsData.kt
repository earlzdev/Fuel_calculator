package com.freed_asd.fuel_calculator.data.consumption.models

import com.freed_asd.fuel_calculator.data.consumption.mappers.ConsCityDataToDbMapper
import com.freed_asd.fuel_calculator.data.consumption.mappers.ConsCityDataToDomainMapper

interface SavedCityConsData {

    fun <T> mapToDb(mapper: ConsCityDataToDbMapper<T>) : T

    fun <T> mapToDomain(mapper: ConsCityDataToDomainMapper<T>) : T

    class Base(
        val id: Long,
        val consumption: Float,
        val mileage: Float
    ) : SavedCityConsData {

        override fun <T> mapToDb(mapper: ConsCityDataToDbMapper<T>) = mapper.mapToDb(id, consumption, mileage)

        override fun <T> mapToDomain(mapper: ConsCityDataToDomainMapper<T>) = mapper.mapToDomain(id, consumption, mileage)
    }
}
