package com.freed_asd.fuel_calculator.domain.consumption.mappers

import com.freed_asd.fuel_calculator.domain.consumption.models.ConsCalcValuesDomain
import com.freed_asd.fuel_calculator.presentation.consumption.mappers.ConsInputUiToDomainMapper

class BaseConsInputUiToDomainMapper : ConsInputUiToDomainMapper<ConsCalcValuesDomain> {

    override fun map(
        distance: Float,
        filledFuel: Float
    ) = ConsCalcValuesDomain.Base(distance, filledFuel)

}