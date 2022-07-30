package com.FreedAsd.fuel_calculator.presentation.calc_trip_price.uiPriceMappers

import com.FreedAsd.fuel_calculator.core.BaseMapper
import com.FreedAsd.fuel_calculator.domain.calc_fuel_price.PriceResultDomain
import com.FreedAsd.fuel_calculator.presentation.calc_trip_price.PriceResultUi

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