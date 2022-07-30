package com.FreedAsd.fuel_calculator.domain.calc_fuel_price

import com.FreedAsd.fuel_calculator.data.Repository
import com.FreedAsd.fuel_calculator.data.calc_trip_price.PriceInputData
import com.FreedAsd.fuel_calculator.data.calc_trip_price.PriceResultData

interface CalcTripPriceRepository : Repository{

    fun calcTripPrice(data: PriceInputData) : PriceResultData
}