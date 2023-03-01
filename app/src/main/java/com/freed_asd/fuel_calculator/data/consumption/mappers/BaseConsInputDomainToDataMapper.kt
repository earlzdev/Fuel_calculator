package com.freed_asd.fuel_calculator.data.consumption.mappers

import com.freed_asd.fuel_calculator.data.consumption.models.ConsCalcValuesData
import com.freed_asd.fuel_calculator.domain.consumption.mappers.ConsInputDomainToDataMapper

class BaseConsInputDomainToDataMapper : ConsInputDomainToDataMapper<ConsCalcValuesData> {

    override fun map(
        distance: Float,
        filledFuel: Float
    ): ConsCalcValuesData {
        return ConsCalcValuesData.Base(distance, filledFuel)
    }
}