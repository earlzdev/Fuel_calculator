package com.FreedAsd.fuel_calculator.domain.calc_fuel_price.domainPriceMappers

import com.FreedAsd.fuel_calculator.data.calc_trip_price.PriceInputData
import com.FreedAsd.fuel_calculator.domain.calc_fuel_price.PriceInputDomain
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