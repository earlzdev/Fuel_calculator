package com.freed_asd.fuel_calculator.domain.tripPrice.mappers

import com.freed_asd.fuel_calculator.domain.tripPrice.models.PriceInputDomain
import com.freed_asd.fuel_calculator.presentation.price.mappers.PriceInputUiToDomainMapper

class BasePriceInputUiToDomainMapper : PriceInputUiToDomainMapper<PriceInputDomain> {

    override fun map(
        averageConsumption: Float,
        distance: Float,
        fuelPrice: Float,
        passengersCount: Float
    ) = PriceInputDomain.Base(averageConsumption, distance, fuelPrice, passengersCount)
}