package com.freed_asd.fuel_calculator.presentation.distance.mappers

import com.freed_asd.fuel_calculator.domain.distance.mappers.ResultDomainToUiMapper
import com.freed_asd.fuel_calculator.presentation.distance.DistanceResultUi

class BaseResultDomainToUiMapper : ResultDomainToUiMapper<DistanceResultUi> {

    override fun map(maxDistance: Float, tripPrice: Float) =
        DistanceResultUi.Base(maxDistance, tripPrice)
}