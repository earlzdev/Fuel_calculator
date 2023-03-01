package com.freed_asd.fuel_calculator.domain.consumption.mappers

import com.freed_asd.fuel_calculator.data.consumption.mappers.ConsResultDataToDomainMapper
import com.freed_asd.fuel_calculator.domain.consumption.models.ConsCalcResultDomain

class BaseConsResultDataToDomainMapper : ConsResultDataToDomainMapper<ConsCalcResultDomain> {

    override fun map(consumption: Float) = ConsCalcResultDomain.Base(consumption)
}