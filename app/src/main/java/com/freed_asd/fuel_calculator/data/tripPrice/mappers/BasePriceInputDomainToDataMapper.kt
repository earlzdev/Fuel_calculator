package com.freed_asd.fuel_calculator.data.tripPrice.mappers

import com.freed_asd.fuel_calculator.data.tripPrice.PriceInputData
import com.freed_asd.fuel_calculator.domain.tripPrice.mappers.PriceInputDomainToDataMapper

class BasePriceInputDomainToDataMapper: PriceInputDomainToDataMapper<PriceInputData> {

    override fun map(
        averageConsumption: Float,
        distance: Float,
        fuelPrice: Float,
        passengersCount: Float
    ) = PriceInputData.Base(averageConsumption, distance, fuelPrice, passengersCount)
}