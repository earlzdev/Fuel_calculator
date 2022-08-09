package com.freed_asd.fuel_calculator.domain.tripPrice.mappers

interface PriceResultDomainToUiMapper<T> {

    fun map(distance: Float, needFuel: Float, generalTripPrice: Float, everyoneTripPrice: Float, passengers: Float) : T
}