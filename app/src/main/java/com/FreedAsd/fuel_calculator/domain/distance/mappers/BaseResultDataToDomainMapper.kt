package com.FreedAsd.fuel_calculator.domain.distance.mappers

import com.FreedAsd.fuel_calculator.data.distance.mappers.ResultDataToDomainMapper
import com.FreedAsd.fuel_calculator.domain.distance.DistanceResultDomain

class BaseResultDataToDomainMapper : ResultDataToDomainMapper<DistanceResultDomain> {

    override fun map(maxDistance: Float, tripPrice: Float) =
        DistanceResultDomain.Base(maxDistance, tripPrice)
}