package com.FreedAsd.fuel_calculator.domain.distance.mappers

interface InputDomainToDataMapper<T> {

    fun map(fuelConsumption: Float, amountOfFuel: Float, fuelPrice: Float) : T
}