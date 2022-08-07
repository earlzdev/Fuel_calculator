package com.freed_asd.fuel_calculator.domain.consumption.mappers

import com.freed_asd.fuel_calculator.data.consumption.mappers.ConsResultDataToDomainMapper
import com.freed_asd.fuel_calculator.domain.consumption.ConsResultDomain

class BaseConsResultDataToDomainMapper : ConsResultDataToDomainMapper<ConsResultDomain> {

    override fun map(consumption: Float) = ConsResultDomain.Base(consumption)
}