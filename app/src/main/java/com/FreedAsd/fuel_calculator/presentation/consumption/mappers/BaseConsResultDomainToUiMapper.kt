package com.freedasd.fuel_calculator.presentation.consumption.mappers

import com.freedasd.fuel_calculator.domain.consumption.mappers.ConsResultDomainToUiMapper
import com.freedasd.fuel_calculator.presentation.consumption.ConsResultUi

class BaseConsResultDomainToUiMapper : ConsResultDomainToUiMapper<ConsResultUi> {

    override fun map(consumption: Float) = ConsResultUi.Base(consumption)
}