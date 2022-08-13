package com.freed_asd.fuel_calculator.data.tripPrice

import com.freed_asd.fuel_calculator.data.local.AppDataBase
import com.freed_asd.fuel_calculator.data.local.price.PriceDb
import com.freed_asd.fuel_calculator.domain.tripPrice.CalcTripPriceRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class CalcTripPriceRepositoryImpl(
    private val appDb: AppDataBase
): CalcTripPriceRepository {

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

    override suspend fun insertIntoDb(value: PriceDb) {
        GlobalScope.launch(Dispatchers.IO) {
            appDb.priceDao().insertValue(value)
        }
    }
}