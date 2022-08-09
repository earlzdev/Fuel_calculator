package com.freed_asd.fuel_calculator.data.tripPrice.mappers

interface PriceResultDataToDomainMapper <T> {

    fun map(distance: Float, needFuel: Float, generalTripPrice: Float, everyoneTripPrice: Float, passengers: Float) : T
}