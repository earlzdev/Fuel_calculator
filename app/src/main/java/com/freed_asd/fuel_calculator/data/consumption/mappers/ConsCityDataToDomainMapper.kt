package com.freed_asd.fuel_calculator.data.consumption.mappers

import com.freed_asd.fuel_calculator.domain.consumption.models.SavedCityConsDomain

interface ConsCityDataToDomainMapper <T> {

    fun mapToDomain(id: Long, consumption: Float, mileage: Float) : T

    class Base : ConsCityDataToDomainMapper<SavedCityConsDomain> {
        override fun mapToDomain(id: Long, consumption: Float, mileage: Float) = SavedCityConsDomain.Base(id, consumption,mileage)
    }
}