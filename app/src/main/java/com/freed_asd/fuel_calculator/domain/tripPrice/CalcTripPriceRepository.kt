package com.freed_asd.fuel_calculator.domain.tripPrice

import com.freed_asd.fuel_calculator.data.Repository
import com.freed_asd.fuel_calculator.data.tripPrice.PriceInputData
import com.freed_asd.fuel_calculator.data.tripPrice.PriceResultData

interface CalcTripPriceRepository : Repository{

<<<<<<< HEAD
    fun calcTripPrice(data: PriceInputData) : PriceResultData
=======
    fun calcTripPrice(input: PriceInputData) : PriceResultData
>>>>>>> master
}