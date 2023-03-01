package com.freed_asd.fuel_calculator.presentation.consumption.mappers

import com.freed_asd.fuel_calculator.domain.consumption.mappers.ConsResultDomainToUiMapper
import com.freed_asd.fuel_calculator.presentation.consumption.models.ConsCalcResultUi

class BaseConsResultDomainToUiMapper : ConsResultDomainToUiMapper<ConsCalcResultUi> {

    override fun map(consumption: Float) = ConsCalcResultUi.Base(consumption)
}