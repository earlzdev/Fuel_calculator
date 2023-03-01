package com.freed_asd.fuel_calculator.data.consumption.mappers

import com.freed_asd.fuel_calculator.data.local.consumption.city.ConsCity

interface ConsCityDataToDbMapper <T> {

    fun mapToDb(id: Long, consumption: Float, mileage: Float) : T

    class Base : ConsCityDataToDbMapper<ConsCity> {
        override fun mapToDb(id: Long, consumption: Float, mileage: Float) = ConsCity(id, consumption, mileage)
    }
}