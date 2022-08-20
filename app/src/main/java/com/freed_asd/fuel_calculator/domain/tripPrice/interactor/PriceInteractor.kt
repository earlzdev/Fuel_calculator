package com.freed_asd.fuel_calculator.domain.tripPrice.interactor

import com.freed_asd.fuel_calculator.data.local.price.BasePriceItemDbMapper
import com.freed_asd.fuel_calculator.data.tripPrice.PriceInputData
import com.freed_asd.fuel_calculator.data.tripPrice.dbItem.BasePriceDbITemDomainMapper
import com.freed_asd.fuel_calculator.data.tripPrice.dbItem.PriceDbItemDataMapper
import com.freed_asd.fuel_calculator.data.tripPrice.mappers.PriceResultDataToDomainMapper
import com.freed_asd.fuel_calculator.domain.tripPrice.CalcTripPriceRepository
import com.freed_asd.fuel_calculator.domain.tripPrice.PriceInputDomain
import com.freed_asd.fuel_calculator.domain.tripPrice.PriceResultDomain
import com.freed_asd.fuel_calculator.domain.tripPrice.dbItem.BasePriceDbItemDataToDomainMapper
import com.freed_asd.fuel_calculator.domain.tripPrice.dbItem.PriceDbItemDomain
import com.freed_asd.fuel_calculator.domain.tripPrice.mappers.BasePriceResultDataToDomainMapper
import com.freed_asd.fuel_calculator.domain.tripPrice.mappers.PriceInputDomainToDataMapper
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.launch

interface PriceInteractor {

    fun calcTripPrice(input: PriceInputDomain) : PriceResultDomain

    suspend fun insertIntoDb(value: PriceDbItemDomain)

    fun allDbValues() : Flow<List<PriceDbItemDomain>>

    suspend fun dbItemById(itemId: Long) : PriceDbItemDomain

    suspend fun deleteItem(itemId: Long)

    suspend fun updateItem(item: Long, newName: String)

    class Base(
        private val repository: CalcTripPriceRepository,
        private val inputMapper: PriceInputDomainToDataMapper<PriceInputData>,
        private val resultMapper: PriceResultDataToDomainMapper<PriceResultDomain>,
        private val priceDbDomainToDataMapper: BasePriceDbITemDomainMapper,
        private val priceDataToDomainMapper: BasePriceDbItemDataToDomainMapper
    ) : PriceInteractor {

        override fun calcTripPrice(input: PriceInputDomain) =
            repository.calcTripPrice(input.map(inputMapper)).map(resultMapper)


        override suspend fun insertIntoDb(value: PriceDbItemDomain) {
            GlobalScope.launch(Dispatchers.IO) {
                repository.insertIntoDb(value.mapToData(priceDbDomainToDataMapper))
            }
        }

        override fun allDbValues() =
            repository.allDbValues().map { list ->
                list.map { priceDataToDomainMapper.mapToDomain(
                    it.id(),
                    it.name(),
                    it.distance(),
                    it.needFuel(),
                    it.generalPrice(),
                    it.everyonePrice()
                ) }
            }

        override suspend fun dbItemById(itemId: Long): PriceDbItemDomain =
            repository.itemById(itemId).mapToDomain(priceDataToDomainMapper)

        override suspend fun deleteItem(itemId: Long) =
            repository.deleteItem(itemId)

        override suspend fun updateItem(item: Long, newName: String) =
            repository.updateItem(item, newName)

    }
}
