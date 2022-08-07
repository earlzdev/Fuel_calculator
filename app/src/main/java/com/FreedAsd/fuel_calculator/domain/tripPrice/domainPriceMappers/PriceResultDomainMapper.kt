package com.freedasd.fuel_calculator.domain.tripPrice.domainPriceMappers

import com.freedasd.fuel_calculator.data.tripPrice.PriceResultData
import com.freedasd.fuel_calculator.domain.tripPrice.PriceResultDomain
import com.freedasd.fuel_calculator.core.BaseMapper

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