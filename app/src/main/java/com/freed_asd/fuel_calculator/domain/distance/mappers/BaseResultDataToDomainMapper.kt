package com.freed_asd.fuel_calculator.domain.distance.mappers

import com.freed_asd.fuel_calculator.data.distance.mappers.ResultDataToDomainMapper
import com.freed_asd.fuel_calculator.domain.distance.models.CalcMaxDistanceResultDomain

class BaseResultDataToDomainMapper : ResultDataToDomainMapper<CalcMaxDistanceResultDomain> {

    override fun map(maxDistance: Float, tripPrice: Float) =
        CalcMaxDistanceResultDomain.Base(maxDistance, tripPrice)
}