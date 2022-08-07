package com.freedasd.fuel_calculator.domain.consumption.mappers

import com.freedasd.fuel_calculator.data.consumption.mappers.ConsResultDataToDomainMapper
import com.freedasd.fuel_calculator.domain.consumption.ConsResultDomain

class BaseConsResultDataToDomainMapper : ConsResultDataToDomainMapper<ConsResultDomain> {

    override fun map(consumption: Float) = ConsResultDomain.Base(consumption)
}