package com.freed_asd.fuel_calculator.data.consumption.models

import com.freed_asd.fuel_calculator.data.consumption.mappers.ConsMixedDataToDbMapper
import com.freed_asd.fuel_calculator.data.consumption.mappers.ConsMixedDataToDomainMapper

interface SavedMixedConsData {

    fun <T> mapToDb(mapper: ConsMixedDataToDbMapper<T>) : T

    fun <T> mapToDomain(mapper: ConsMixedDataToDomainMapper<T>) : T

    class Base(
        val id: Long,
        val consumption: Float,
        val mileage: Float
    ) : SavedMixedConsData {

        override fun <T> mapToDb(mapper: ConsMixedDataToDbMapper<T>) = mapper.mapToDb(id, consumption, mileage)

        override fun <T> mapToDomain(mapper: ConsMixedDataToDomainMapper<T>) = mapper.mapToDomain(id, consumption, mileage)
    }
}