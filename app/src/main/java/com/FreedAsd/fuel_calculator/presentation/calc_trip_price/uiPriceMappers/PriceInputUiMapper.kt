package com.FreedAsd.fuel_calculator.presentation.calc_trip_price.uiPriceMappers

import com.FreedAsd.fuel_calculator.core.BaseMapper
import com.FreedAsd.fuel_calculator.domain.calc_fuel_price.PriceInputDomain
import com.FreedAsd.fuel_calculator.presentation.calc_trip_price.PriceInputDataUi

interface PriceInputUiMapper: BaseMapper<PriceInputDataUi, PriceInputDomain> {

    class Base: PriceInputUiMapper {
        override fun map(data: PriceInputDataUi) = PriceInputDomain(
            averageConsumption = data.averageConsumption,
            distance = data.distance,
            fuelPrice = data.fuelPrice,
            passengersCount = data.passengersCount
        )
    }
}