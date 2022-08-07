package com.FreedAsd.fuel_calculator.domain.tripPrice

import com.FreedAsd.fuel_calculator.data.Repository
import com.FreedAsd.fuel_calculator.data.tripPrice.PriceInputData
import com.FreedAsd.fuel_calculator.data.tripPrice.PriceResultData

interface CalcTripPriceRepository : Repository{

    fun calcTripPrice(data: PriceInputData) : PriceResultData
}