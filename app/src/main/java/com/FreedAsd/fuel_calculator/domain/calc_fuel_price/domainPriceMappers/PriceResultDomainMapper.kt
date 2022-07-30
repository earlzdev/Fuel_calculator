package com.FreedAsd.fuel_calculator.domain.calc_fuel_price.domainPriceMappers

import com.FreedAsd.fuel_calculator.data.calc_trip_price.PriceResultData
import com.FreedAsd.fuel_calculator.domain.calc_fuel_price.PriceResultDomain
import com.FreedAsd.fuel_calculator.core.BaseMapper

interface PriceResultDomainMapper : BaseMapper<PriceResultDomain, PriceResultData> {

    fun map(result: PriceResultData): PriceResultDomain

    class Base : PriceResultDomainMapper {
        override fun map(data: PriceResultDomain): PriceResultData = PriceResultData(
            data.distance,
            data.needFuel,
            data.generalTripPrice,
            data.everyoneTripPrice,
            data.passengers
        )

        override fun map(result: PriceResultData) = PriceResultDomain(
            distance = result.distance,
            needFuel = result.needFuel,
            generalTripPrice = result.generalTripPrice,
            everyoneTripPrice = result.everyoneTripPrice,
            passengers = result.passengers
        )
    }
}