package com.freed_asd.fuel_calculator.data.consumption

import com.freed_asd.fuel_calculator.domain.consumption.ConsumptionRepository

class ConsumptionRepositoryImpl : ConsumptionRepository {

    override fun calcConsumption(input: ConsInputData): ConsResultData {
        return ConsResultData.Base(
            consumption = input.consumption()
        )
    }
}