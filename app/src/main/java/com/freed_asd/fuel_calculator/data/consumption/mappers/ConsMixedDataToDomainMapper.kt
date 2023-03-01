package com.freed_asd.fuel_calculator.data.consumption.mappers

import com.freed_asd.fuel_calculator.domain.consumption.models.SavedMixedDomain

interface ConsMixedDataToDomainMapper<T> {

    fun mapToDomain(id: Long, consumption: Float, mileage: Float) : T

    class Base : ConsMixedDataToDomainMapper<SavedMixedDomain> {

        override fun mapToDomain(id: Long, consumption: Float, mileage: Float) = SavedMixedDomain.Base(id, consumption, mileage)
    }
}