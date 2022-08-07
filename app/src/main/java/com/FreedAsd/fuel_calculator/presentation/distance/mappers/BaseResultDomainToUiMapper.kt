package com.FreedAsd.fuel_calculator.presentation.distance.mappers

import com.FreedAsd.fuel_calculator.domain.distance.mappers.ResultDomainToUiMapper
import com.FreedAsd.fuel_calculator.presentation.distance.DistanceResultUi

class BaseResultDomainToUiMapper : ResultDomainToUiMapper<DistanceResultUi> {

    override fun map(maxDistance: Float, tripPrice: Float) =
        DistanceResultUi.Base(maxDistance, tripPrice)
}