package com.freed_asd.fuel_calculator.data.consumption.dbItems.mixed

import com.freed_asd.fuel_calculator.data.local.consumption.mixed.ConsMixed
import com.freed_asd.fuel_calculator.domain.consumption.dbItem.mixed.ConsMixedDbItemDomain

interface ConsMixedDbItemData {

    fun <T> mapToDb(mapper: ConsMixedDataToDbMapper<T>) : T

    fun <T> mapToDomain(mapper: ConsMixedDataToDomainMapper<T>) : T

    class Base(
    val id: Long,
    val consumption: Float,
    val mileage: Float
    ) : ConsMixedDbItemData {
        override fun <T> mapToDb(mapper: ConsMixedDataToDbMapper<T>) = mapper.mapToDb(id, consumption, mileage)

        override fun <T> mapToDomain(mapper: ConsMixedDataToDomainMapper<T>) = mapper.mapToDomain(id, consumption, mileage)
    }
}

interface ConsMixedDataToDbMapper<T> {

    fun mapToDb(id: Long, consumption: Float, mileage: Float) : T

    class Base() : ConsMixedDataToDbMapper<ConsMixed> {

        override fun mapToDb(id: Long, consumption: Float, mileage: Float) = ConsMixed(id, consumption, mileage)
    }
}

interface ConsMixedDataToDomainMapper<T> {

    fun mapToDomain(id: Long, consumption: Float, mileage: Float) : T

    class Base() : ConsMixedDataToDomainMapper<ConsMixedDbItemDomain> {

        override fun mapToDomain(id: Long, consumption: Float, mileage: Float) = ConsMixedDbItemDomain.Base(id, consumption, mileage)
    }
}