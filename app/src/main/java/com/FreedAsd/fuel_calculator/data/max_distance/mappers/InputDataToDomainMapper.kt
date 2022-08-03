package com.FreedAsd.fuel_calculator.data.max_distance.mappers

interface InputDataToDomainMapper<T> {

    fun map(fuelConsumption: Float, amountOfFuel: Int, fuelPrice: Float): T
}