package com.freed_asd.fuel_calculator.data.tripPrice

import com.freed_asd.fuel_calculator.domain.tripPrice.CalcTripPriceRepository

class CalcTripPriceRepositoryImpl: CalcTripPriceRepository {

<<<<<<< HEAD
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
=======
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
>>>>>>> master
}