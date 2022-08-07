package com.freedasd.fuel_calculator.domain.distance.mappers

import com.freedasd.fuel_calculator.domain.distance.DistanceInputDomain
import com.freedasd.fuel_calculator.presentation.distance.mappers.InputUiToDomainMapper

class BaseInputUiToDomainMapper : InputUiToDomainMapper<DistanceInputDomain> {

    override fun map(
        fuelConsumption: Float,
        amountOfFuel: Float,
        fuelPrice: Float
    ): DistanceInputDomain =
        DistanceInputDomain.Base(fuelConsumption, amountOfFuel, fuelPrice)
}