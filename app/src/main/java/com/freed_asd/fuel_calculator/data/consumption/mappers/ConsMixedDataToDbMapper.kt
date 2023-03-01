package com.freed_asd.fuel_calculator.data.consumption.mappers

import com.freed_asd.fuel_calculator.data.local.consumption.mixed.ConsMixed

interface ConsMixedDataToDbMapper<T> {

    fun mapToDb(id: Long, consumption: Float, mileage: Float) : T

    class Base : ConsMixedDataToDbMapper<ConsMixed> {

        override fun mapToDb(id: Long, consumption: Float, mileage: Float) = ConsMixed(id, consumption, mileage)
    }
}