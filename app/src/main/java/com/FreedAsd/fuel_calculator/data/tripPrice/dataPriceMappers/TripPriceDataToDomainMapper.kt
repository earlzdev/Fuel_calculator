package com.freedasd.fuel_calculator.data.tripPrice.dataPriceMappers

import com.freedasd.fuel_calculator.data.tripPrice.PriceResultData
import com.freedasd.fuel_calculator.domain.tripPrice.PriceResultDomain
import com.freedasd.fuel_calculator.core.BaseMapper

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