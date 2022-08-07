package com.freedasd.fuel_calculator.data.consumption.mappers

import com.freedasd.fuel_calculator.data.consumption.ConsInputData
import com.freedasd.fuel_calculator.domain.consumption.mappers.ConsInputDomainToDataMapper

class BaseConsInputDomainToDataMapper : ConsInputDomainToDataMapper<ConsInputData> {

    override fun map(
        currentMileage: Float,
        previousMileage: Float,
        filledFuel: Float
    ): ConsInputData {
        return ConsInputData.Base(currentMileage, previousMileage, filledFuel)
    }
}