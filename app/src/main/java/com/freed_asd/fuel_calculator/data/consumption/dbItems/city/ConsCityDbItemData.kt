package com.freed_asd.fuel_calculator.data.consumption.dbItems.city

import com.freed_asd.fuel_calculator.data.local.consumption.city.ConsCity
import com.freed_asd.fuel_calculator.domain.consumption.dbItem.city.ConsCityDbItemDomain

interface ConsCityDbItemData {

    fun <T> mapToDb(mapper: ConsCityDataToDbMapper<T>) : T

    fun <T> mapToDomain(mapper: ConsCityDataToDomainMapper<T>) : T

    class Base(
        val id: Long,
        val consumption: Float,
        val mileage: Float
   ) : ConsCityDbItemData {

        override fun <T> mapToDb(mapper: ConsCityDataToDbMapper<T>) = mapper.mapToDb(id, consumption, mileage)

        override fun <T> mapToDomain(mapper: ConsCityDataToDomainMapper<T>) = mapper.mapToDomain(id, consumption, mileage)
    }
}

interface ConsCityDataToDbMapper <T> {

    fun mapToDb(id: Long, consumption: Float, mileage: Float) : T

    class Base() : ConsCityDataToDbMapper<ConsCity> {
        override fun mapToDb(id: Long, consumption: Float, mileage: Float) = ConsCity(id, consumption, mileage)
    }
}

interface ConsCityDataToDomainMapper <T> {

    fun mapToDomain(id: Long, consumption: Float, mileage: Float) : T

    class Base() : ConsCityDataToDomainMapper<ConsCityDbItemDomain> {
        override fun mapToDomain(id: Long, consumption: Float, mileage: Float) = ConsCityDbItemDomain.Base(id, consumption,mileage)
    }
}