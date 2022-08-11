package com.freed_asd.fuel_calculator.domain.consumption.mappers

import com.freed_asd.fuel_calculator.domain.consumption.ConsInputDomain
import com.freed_asd.fuel_calculator.presentation.consumption.mappers.ConsInputUiToDomainMapper

class BaseConsInputUiToDomainMapper : ConsInputUiToDomainMapper<ConsInputDomain> {

    override fun map(
        distance: Float,
        filledFuel: Float
    ) = ConsInputDomain.Base(distance, filledFuel)

}