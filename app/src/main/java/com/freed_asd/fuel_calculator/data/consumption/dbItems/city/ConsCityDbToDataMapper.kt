package com.freed_asd.fuel_calculator.data.consumption.dbItems.city

import com.freed_asd.fuel_calculator.data.local.consumption.city.ConsCity

interface ConsCityDbToDataMapper<T> {

    fun mapToData(value: ConsCity) : T

    class Base() : ConsCityDbToDataMapper<ConsCityDbItemData> {
        override fun mapToData(value: ConsCity) = ConsCityDbItemData.Base(value.id, value.consumption, value.mileage)
    }
}