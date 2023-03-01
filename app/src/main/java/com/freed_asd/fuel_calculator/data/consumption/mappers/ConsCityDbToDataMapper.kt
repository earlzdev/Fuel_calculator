package com.freed_asd.fuel_calculator.data.consumption.mappers

import com.freed_asd.fuel_calculator.data.consumption.models.SavedCityConsData
import com.freed_asd.fuel_calculator.data.local.consumption.city.ConsCity

interface ConsCityDbToDataMapper<T> {

    fun mapToData(value: ConsCity) : T

    class Base : ConsCityDbToDataMapper<SavedCityConsData> {
        override fun mapToData(value: ConsCity) =
            SavedCityConsData.Base(value.id, value.consumption, value.mileage)
    }
}