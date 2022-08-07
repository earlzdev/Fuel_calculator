package com.freedasd.fuel_calculator.presentation.tripPrice.uiPriceMappers

import com.freedasd.fuel_calculator.core.BaseMapper
import com.freedasd.fuel_calculator.domain.tripPrice.PriceInputDomain
import com.freedasd.fuel_calculator.presentation.tripPrice.PriceInputDataUi

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