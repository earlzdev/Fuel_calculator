package com.freedasd.fuel_calculator.domain.consumption.mappers

import com.freedasd.fuel_calculator.domain.consumption.ConsInputDomain
import com.freedasd.fuel_calculator.presentation.consumption.mappers.ConsInputUiToDomainMapper

class BaseConsInputUiToDomainMapper : ConsInputUiToDomainMapper<ConsInputDomain> {

    override fun map(
        currentMileage: Float,
        previousMileage: Float,
        filledFuel: Float
    ) = ConsInputDomain.Base(currentMileage, previousMileage, filledFuel)
}