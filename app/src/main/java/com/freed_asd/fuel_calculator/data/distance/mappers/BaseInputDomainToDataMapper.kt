package com.freed_asd.fuel_calculator.data.distance.mappers

import com.freed_asd.fuel_calculator.data.distance.models.CalcMaxDistanceValuesData
import com.freed_asd.fuel_calculator.domain.distance.mappers.InputDomainToDataMapper

class BaseInputDomainToDataMapper : InputDomainToDataMapper<CalcMaxDistanceValuesData> {

    override fun map(
        fuelConsumption: Float,
        amountOfFuel: Float,
        fuelPrice: Float
    ): CalcMaxDistanceValuesData = CalcMaxDistanceValuesData.Base(fuelConsumption, amountOfFuel, fuelPrice)

}