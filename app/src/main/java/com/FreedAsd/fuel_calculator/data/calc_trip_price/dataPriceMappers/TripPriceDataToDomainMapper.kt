package com.FreedAsd.fuel_calculator.data.calc_trip_price.dataPriceMappers

import com.FreedAsd.fuel_calculator.data.calc_trip_price.PriceResultData
import com.FreedAsd.fuel_calculator.domain.calc_fuel_price.PriceResultDomain
import com.FreedAsd.fuel_calculator.core.BaseMapper

interface TripPriceDataToDomainMapper : BaseMapper<PriceResultData, PriceResultDomain> {

    class Base : TripPriceDataToDomainMapper {
        override fun map(data: PriceResultData): PriceResultDomain = PriceResultDomain(
            data.distance,
            data.needFuel,
            data.generalTripPrice,
            data.everyoneTripPrice,
            data.passengers
        )
    }
}