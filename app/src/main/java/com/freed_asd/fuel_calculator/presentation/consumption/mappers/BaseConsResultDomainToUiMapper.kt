package com.freed_asd.fuel_calculator.presentation.consumption.mappers

import com.freed_asd.fuel_calculator.domain.consumption.mappers.ConsResultDomainToUiMapper
import com.freed_asd.fuel_calculator.presentation.consumption.ConsResultUi

class BaseConsResultDomainToUiMapper : ConsResultDomainToUiMapper<ConsResultUi> {

    override fun map(consumption: Float) = ConsResultUi.Base(consumption)
}