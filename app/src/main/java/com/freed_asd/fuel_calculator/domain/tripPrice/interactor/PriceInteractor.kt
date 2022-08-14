package com.freed_asd.fuel_calculator.domain.tripPrice.interactor

import com.freed_asd.fuel_calculator.data.tripPrice.PriceInputData
import com.freed_asd.fuel_calculator.data.tripPrice.dbItem.BasePriceDbITemDomainMapper
import com.freed_asd.fuel_calculator.data.tripPrice.mappers.PriceResultDataToDomainMapper
import com.freed_asd.fuel_calculator.domain.tripPrice.CalcTripPriceRepository
import com.freed_asd.fuel_calculator.domain.tripPrice.PriceInputDomain
import com.freed_asd.fuel_calculator.domain.tripPrice.PriceResultDomain
import com.freed_asd.fuel_calculator.domain.tripPrice.dbItem.PriceDbItemDomain
import com.freed_asd.fuel_calculator.domain.tripPrice.mappers.PriceInputDomainToDataMapper
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

interface PriceInteractor {

    fun calcTripPrice(input: PriceInputDomain) : PriceResultDomain

    suspend fun insertIntoDb(value: PriceDbItemDomain)

    class Base(
        private val repository: CalcTripPriceRepository,
        private val inputMapper: PriceInputDomainToDataMapper<PriceInputData>,
        private val resultMapper: PriceResultDataToDomainMapper<PriceResultDomain>,
        private val priceDbDomainToDataMapper: BasePriceDbITemDomainMapper
    ) : PriceInteractor {

        override fun calcTripPrice(input: PriceInputDomain) : PriceResultDomain {
            return repository.calcTripPrice(input.map(inputMapper)).map(resultMapper)
        }

        override suspend fun insertIntoDb(value: PriceDbItemDomain) {
            GlobalScope.launch(Dispatchers.IO) {
                repository.insertIntoDb(value.mapToData(priceDbDomainToDataMapper))
            }
        }
    }
}
