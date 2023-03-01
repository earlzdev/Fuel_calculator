package com.freed_asd.fuel_calculator.data.tripPrice

import com.freed_asd.fuel_calculator.data.local.AppDataBase
import com.freed_asd.fuel_calculator.data.local.mappers.BaseSavedTripPriceDataToDbMapper
import com.freed_asd.fuel_calculator.data.tripPrice.models.*
import com.freed_asd.fuel_calculator.domain.tripPrice.CalcTripPriceRepository

class PriceRepositoryImpl(
    private val appDb: AppDataBase,
    private val savedTripPriceDataToDbMapper: BaseSavedTripPriceDataToDbMapper,
    private val savedTripPriceDbToDataMapper: SavedTripPriceDbToDataMapper.BaseSavedTripPriceDbToDataMapper
): CalcTripPriceRepository {

    override fun calcTripPrice(input: PriceInputData): PriceResultData {
        return PriceResultData.Base(
            distance = input.distance(),
            needFuel = amountOfFuel(input),
            generalTripPrice = generalPrice(input),
            everyoneTripPrice = priceForOnePerson(input),
            passengers = input.passengers()
        )
    }

    private fun priceForOnePerson(input: PriceInputData) = input.onePersonPrice()

    private fun generalPrice(input: PriceInputData) = input.generalPrice()

    private fun amountOfFuel(input: PriceInputData) = input.needFuel()

    override suspend fun insertIntoDb(value: PriceDbItemData) {
        appDb.priceDao().insertValue(value.mapToDb(savedTripPriceDataToDbMapper))
    }

    override suspend fun fetchAllPriceValuesFromDb() =
        appDb.priceDao().allValues().map { it.mapToData(savedTripPriceDbToDataMapper) }

    override suspend fun itemById(itemId: Long): PriceDbItemData {
        val itemDb = appDb.priceDao().itemById(itemId)
        return savedTripPriceDbToDataMapper.mapToData(itemDb)
    }

    override suspend fun deleteItem(itemId: Long) {
        appDb.priceDao().deleteValue(itemId)
    }

    override suspend fun updateItem(item: Long, newName: String) {
        appDb.priceDao().updateItem(item, newName)
    }
}