package com.FreedAsd.fuel_calculator.domain.max_distance.mappers

import com.FreedAsd.fuel_calculator.data.max_distance.mappers.ResultDataToDomainMapper
import com.FreedAsd.fuel_calculator.domain.max_distance.DistanceResultDomain

class BaseDistanceResultMapper: ResultDataToDomainMapper<DistanceResultDomain> {

    override fun map(maxDistance: Int, tripPrice: Float) = DistanceResultDomain.Base(maxDistance, tripPrice)
}