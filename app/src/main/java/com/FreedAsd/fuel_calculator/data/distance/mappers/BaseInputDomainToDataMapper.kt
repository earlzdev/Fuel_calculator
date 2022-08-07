package com.FreedAsd.fuel_calculator.data.distance.mappers

import com.FreedAsd.fuel_calculator.data.distance.DistanceInputData
import com.FreedAsd.fuel_calculator.domain.distance.mappers.InputDomainToDataMapper

class BaseInputDomainToDataMapper : InputDomainToDataMapper<DistanceInputData> {

    override fun map(
        fuelConsumption: Float,
        amountOfFuel: Float,
        fuelPrice: Float
    ): DistanceInputData = DistanceInputData.Base(fuelConsumption, amountOfFuel, fuelPrice)

}