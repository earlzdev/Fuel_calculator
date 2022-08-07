package com.FreedAsd.fuel_calculator.domain.tripPrice.domainPriceMappers

import com.FreedAsd.fuel_calculator.data.tripPrice.PriceInputData
import com.FreedAsd.fuel_calculator.domain.tripPrice.PriceInputDomain
import com.FreedAsd.fuel_calculator.core.BaseMapper

interface InputDataDomainMapper: BaseMapper<PriceInputDomain, PriceInputData> {

    class Base : InputDataDomainMapper {
        override fun map(data: PriceInputDomain): PriceInputData = PriceInputData(
            data.averageConsumption,
            data.distance,
            data.fuelPrice,
            data.passengersCount
        )
    }
}