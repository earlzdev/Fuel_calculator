package com.freedasd.fuel_calculator.domain.consumption

import com.freedasd.fuel_calculator.data.consumption.ConsInputData
import com.freedasd.fuel_calculator.data.consumption.ConsResultData

interface ConsumptionRepository {

    fun calcConsumption(input: ConsInputData) : ConsResultData
}