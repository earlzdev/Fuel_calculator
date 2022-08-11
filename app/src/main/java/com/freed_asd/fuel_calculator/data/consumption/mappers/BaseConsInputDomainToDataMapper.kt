package com.freed_asd.fuel_calculator.data.consumption.mappers

import com.freed_asd.fuel_calculator.data.consumption.ConsInputData
import com.freed_asd.fuel_calculator.domain.consumption.mappers.ConsInputDomainToDataMapper

class BaseConsInputDomainToDataMapper : ConsInputDomainToDataMapper<ConsInputData> {

    override fun map(
<<<<<<< HEAD
        distance: Float,
        filledFuel: Float
    ): ConsInputData {
        return ConsInputData.Base(distance, filledFuel)
=======
        currentMileage: Float,
        previousMileage: Float,
        filledFuel: Float
    ): ConsInputData {
        return ConsInputData.Base(currentMileage, previousMileage, filledFuel)
>>>>>>> master
    }
}