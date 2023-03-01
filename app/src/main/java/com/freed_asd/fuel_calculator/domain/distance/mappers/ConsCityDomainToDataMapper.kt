package com.freed_asd.fuel_calculator.domain.distance.mappers

import com.freed_asd.fuel_calculator.data.consumption.models.SavedCityConsData

interface ConsCityDomainToDataMapper <T> {

    fun mapToData(id: Long, consumption: Float, mileage: Float) : T

    class Base() : ConsCityDomainToDataMapper<SavedCityConsData> {
        override fun mapToData(id: Long, consumption: Float, mileage: Float) = SavedCityConsData.Base(id, consumption, mileage)
    }
}