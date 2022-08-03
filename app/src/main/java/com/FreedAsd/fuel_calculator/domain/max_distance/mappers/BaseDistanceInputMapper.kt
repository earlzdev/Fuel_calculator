package com.FreedAsd.fuel_calculator.domain.max_distance.mappers

import com.FreedAsd.fuel_calculator.data.max_distance.mappers.InputDataToDomainMapper
import com.FreedAsd.fuel_calculator.domain.max_distance.DistanceInputDomain

class BaseDistanceInputMapper: InputDataToDomainMapper<DistanceInputDomain> {

    override fun map(
        fuelConsumption: Float,
        amountOfFuel: Int,
        fuelPrice: Float
    ) = DistanceInputDomain.Base(fuelConsumption, amountOfFuel, fuelPrice)
}