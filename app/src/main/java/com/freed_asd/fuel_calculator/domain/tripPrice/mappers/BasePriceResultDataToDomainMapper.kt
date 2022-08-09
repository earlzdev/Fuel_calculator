package com.freed_asd.fuel_calculator.domain.tripPrice.mappers

import com.freed_asd.fuel_calculator.data.tripPrice.mappers.PriceResultDataToDomainMapper
import com.freed_asd.fuel_calculator.domain.tripPrice.PriceResultDomain

class BasePriceResultDataToDomainMapper : PriceResultDataToDomainMapper<PriceResultDomain>{

    override fun map(
        distance: Float,
        needFuel: Float,
        generalTripPrice: Float,
        everyoneTripPrice: Float,
        passengers: Float
    ) = PriceResultDomain.Base(distance, needFuel, generalTripPrice, everyoneTripPrice, passengers)
}