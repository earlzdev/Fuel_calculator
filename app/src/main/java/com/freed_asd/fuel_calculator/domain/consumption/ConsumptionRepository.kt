package com.freed_asd.fuel_calculator.domain.consumption

import com.freed_asd.fuel_calculator.data.consumption.ConsInputData
import com.freed_asd.fuel_calculator.data.consumption.ConsResultData

interface ConsumptionRepository {

    fun calcConsumption(input: ConsInputData) : ConsResultData
}