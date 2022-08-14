package com.freed_asd.fuel_calculator.presentation.price.mappers

interface PriceInputUiToDomainMapper<T> {

    fun map(averageConsumption: Float, distance: Float, fuelPrice: Float = 1f, passengersCount: Float = 1f) : T
}