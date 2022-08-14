package com.freed_asd.fuel_calculator.presentation.price.mappers

import com.freed_asd.fuel_calculator.domain.tripPrice.mappers.PriceResultDomainToUiMapper
import com.freed_asd.fuel_calculator.presentation.price.PriceResultUi

class BasePriceResultDomainToUiMapper: PriceResultDomainToUiMapper<PriceResultUi> {

    override fun map(
        distance: Float,
        needFuel: Float,
        generalTripPrice: Float,
        everyoneTripPrice: Float,
        passengers: Float
    ) = PriceResultUi.Base(distance, needFuel, generalTripPrice, everyoneTripPrice, passengers)
}