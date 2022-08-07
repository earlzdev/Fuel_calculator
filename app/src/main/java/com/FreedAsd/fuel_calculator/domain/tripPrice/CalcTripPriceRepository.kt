package com.freedasd.fuel_calculator.domain.tripPrice

import com.freedasd.fuel_calculator.data.Repository
import com.freedasd.fuel_calculator.data.tripPrice.PriceInputData
import com.freedasd.fuel_calculator.data.tripPrice.PriceResultData

interface CalcTripPriceRepository : Repository{

    fun calcTripPrice(data: PriceInputData) : PriceResultData
}