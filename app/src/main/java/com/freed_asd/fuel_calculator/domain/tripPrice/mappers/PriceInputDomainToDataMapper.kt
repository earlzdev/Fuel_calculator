package com.freed_asd.fuel_calculator.domain.tripPrice.mappers

interface PriceInputDomainToDataMapper <T> {

    fun map(averageConsumption: Float, distance: Float, fuelPrice: Float = 1f, passengersCount: Float = 1f) : T
}