package com.freedasd.fuel_calculator.presentation.tripPrice.uiPriceMappers

import com.freedasd.fuel_calculator.core.BaseMapper
import com.freedasd.fuel_calculator.domain.tripPrice.PriceResultDomain
import com.freedasd.fuel_calculator.presentation.tripPrice.PriceResultUi

interface PriceResultUiMapper: BaseMapper<PriceResultDomain, PriceResultUi> {

    class Base: PriceResultUiMapper {
        override fun map(data: PriceResultDomain) = PriceResultUi(
            distance = data.distance,
            needFuel = data.needFuel,
            generalTripPrice = data.generalTripPrice,
            everyoneTripPrice = data.everyoneTripPrice,
            passengers = data.passengers
        )
    }
}