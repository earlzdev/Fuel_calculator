package com.freed_asd.fuel_calculator.domain.distance.mappers

import com.freed_asd.fuel_calculator.data.distance.mappers.ResultDataToDomainMapper
import com.freed_asd.fuel_calculator.domain.distance.DistanceResultDomain

class BaseResultDataToDomainMapper : ResultDataToDomainMapper<DistanceResultDomain> {

    override fun map(maxDistance: Float, tripPrice: Float) =
        DistanceResultDomain.Base(maxDistance, tripPrice)
}