package com.FreedAsd.fuel_calculator.data.calc_trip_price

import com.FreedAsd.fuel_calculator.domain.calc_fuel_price.CalcTripPriceRepository

class CalcTripPriceRepositoryImpl: CalcTripPriceRepository {

    override fun calcTripPrice(data: PriceInputData): PriceResultData {
        return PriceResultData(
            distance = data.distance,
            needFuel = calcNeedOfFuel(data),
            generalTripPrice = calcGeneralTripPrice(data),
            everyoneTripPrice = calcTripPriceForOnePerson(data),
            passengers = data.passengersCount
        )
    }

    private fun calcTripPriceForOnePerson(data: PriceInputData) =
        (((data.distance / 100)
                * data.averageConsumption)
                * data.fuelPrice) / data.passengersCount


    private fun calcGeneralTripPrice(data: PriceInputData) =
        (((data.distance / 100)
                * data.averageConsumption)
                * data.fuelPrice)

    private fun calcNeedOfFuel(data: PriceInputData) =
        (data.distance / 100) * data.averageConsumption
}