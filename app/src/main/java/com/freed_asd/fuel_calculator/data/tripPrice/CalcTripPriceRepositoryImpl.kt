package com.freed_asd.fuel_calculator.data.tripPrice

import com.freed_asd.fuel_calculator.domain.tripPrice.CalcTripPriceRepository

class CalcTripPriceRepositoryImpl: CalcTripPriceRepository {

    override fun calcTripPrice(input: PriceInputData): PriceResultData {
        return PriceResultData.Base(
            distance = input.distance(),
            needFuel = calcNeedOfFuel(input),
            generalTripPrice = calcGeneralTripPrice(input),
            everyoneTripPrice = calcTripPriceForOnePerson(input),
            passengers = input.passengers()
        )
    }

    private fun calcTripPriceForOnePerson(input: PriceInputData) = input.onePersonPrice()

    private fun calcGeneralTripPrice(input: PriceInputData) = input.generalPrice()

    private fun calcNeedOfFuel(input: PriceInputData) = input.needFuel()
}