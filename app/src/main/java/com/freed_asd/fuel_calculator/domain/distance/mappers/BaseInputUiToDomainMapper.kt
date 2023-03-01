package com.freed_asd.fuel_calculator.domain.distance.mappers

import com.freed_asd.fuel_calculator.domain.distance.models.CalcMaxDistanceValuesDomain
import com.freed_asd.fuel_calculator.presentation.distance.mappers.InputUiToDomainMapper

class BaseInputUiToDomainMapper : InputUiToDomainMapper<CalcMaxDistanceValuesDomain> {

    override fun map(
        fuelConsumption: Float,
        amountOfFuel: Float,
        fuelPrice: Float
    ): CalcMaxDistanceValuesDomain =
        CalcMaxDistanceValuesDomain.Base(fuelConsumption, amountOfFuel, fuelPrice)
}