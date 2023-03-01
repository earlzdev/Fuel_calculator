package com.freed_asd.fuel_calculator.domain.tripPrice

import com.freed_asd.fuel_calculator.data.tripPrice.mappers.PriceResultDataToDomainMapper
import com.freed_asd.fuel_calculator.data.tripPrice.models.PriceDbItemData
import com.freed_asd.fuel_calculator.data.tripPrice.models.PriceInputData
import com.freed_asd.fuel_calculator.domain.tripPrice.mappers.BasePriceDbItemDataToDomainMapper
import com.freed_asd.fuel_calculator.domain.tripPrice.mappers.PriceInputDomainToDataMapper
import com.freed_asd.fuel_calculator.domain.tripPrice.mappers.SavedTripPriceDomainToDataMapper
import com.freed_asd.fuel_calculator.domain.tripPrice.models.SavedTripPriceDomain
import com.freed_asd.fuel_calculator.domain.tripPrice.models.PriceInputDomain
import com.freed_asd.fuel_calculator.domain.tripPrice.models.PriceResultDomain

interface PriceInteractor {

    fun calcTripPrice(input: PriceInputDomain) : PriceResultDomain

    suspend fun insertIntoDb(value: SavedTripPriceDomain)

    suspend fun fetchAllPriceValuesFromDb() : List<SavedTripPriceDomain>

    suspend fun dbItemById(itemId: Long) : SavedTripPriceDomain

    suspend fun deleteItem(itemId: Long)

    suspend fun updateItem(item: Long, newName: String)

    class Base(
        private val repository: CalcTripPriceRepository,
        private val inputMapper: PriceInputDomainToDataMapper<PriceInputData>,
        private val resultMapper: PriceResultDataToDomainMapper<PriceResultDomain>,
        private val priceDbDomainToDataMapper: SavedTripPriceDomainToDataMapper<PriceDbItemData>,
        private val priceDataToDomainMapper: BasePriceDbItemDataToDomainMapper
    ) : PriceInteractor {

        override fun calcTripPrice(input: PriceInputDomain) =
            repository.calcTripPrice(input.map(inputMapper)).map(resultMapper)


        override suspend fun insertIntoDb(value: SavedTripPriceDomain) {
            repository.insertIntoDb(value.mapToData(priceDbDomainToDataMapper))
        }

        override suspend fun fetchAllPriceValuesFromDb() =
            repository.fetchAllPriceValuesFromDb().map {
                it.mapToDomain(priceDataToDomainMapper)
            }

        override suspend fun dbItemById(itemId: Long): SavedTripPriceDomain =
            repository.itemById(itemId).mapToDomain(priceDataToDomainMapper)

        override suspend fun deleteItem(itemId: Long) =
            repository.deleteItem(itemId)

        override suspend fun updateItem(item: Long, newName: String) =
            repository.updateItem(item, newName)
    }
}
