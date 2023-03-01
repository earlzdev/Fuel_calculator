package com.freed_asd.fuel_calculator.data.tripPrice.models

import com.freed_asd.fuel_calculator.data.tripPrice.mappers.PriceResultDataToDomainMapper

interface PriceResultData {

    fun <T> map(mapper: PriceResultDataToDomainMapper<T>) : T

    class Base(
        private val distance: Float,
        private val needFuel: Float,
        private val generalTripPrice: Float,
        private val everyoneTripPrice: Float,
        private val passengers: Float
    ) : PriceResultData {
        override fun <T> map(mapper: PriceResultDataToDomainMapper<T>) =
            mapper.map(distance, needFuel, generalTripPrice, everyoneTripPrice, passengers)
    }
}
