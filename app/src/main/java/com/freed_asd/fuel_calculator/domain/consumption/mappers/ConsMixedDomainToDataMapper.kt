package com.freed_asd.fuel_calculator.domain.consumption.mappers

import com.freed_asd.fuel_calculator.data.consumption.models.SavedMixedConsData

interface ConsMixedDomainToDataMapper<T> {

    fun mapToData(id: Long, consumption: Float, mileage: Float): T

    class Base : ConsMixedDomainToDataMapper<SavedMixedConsData> {
        override fun mapToData(id: Long, consumption: Float, mileage: Float) =
            SavedMixedConsData.Base(id, consumption, mileage)
    }
}