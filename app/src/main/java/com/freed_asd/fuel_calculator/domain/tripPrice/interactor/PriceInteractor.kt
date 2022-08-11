package com.freed_asd.fuel_calculator.domain.tripPrice.interactor

import com.freed_asd.fuel_calculator.data.tripPrice.PriceInputData
import com.freed_asd.fuel_calculator.data.tripPrice.mappers.PriceResultDataToDomainMapper
import com.freed_asd.fuel_calculator.domain.tripPrice.CalcTripPriceRepository
import com.freed_asd.fuel_calculator.domain.tripPrice.PriceInputDomain
import com.freed_asd.fuel_calculator.domain.tripPrice.PriceResultDomain
import com.freed_asd.fuel_calculator.domain.tripPrice.mappers.PriceInputDomainToDataMapper

interface PriceInteractor {

    fun calcTripPrice(input: PriceInputDomain) : PriceResultDomain

    class Base(
        private val repository: CalcTripPriceRepository,
        private val inputMapper: PriceInputDomainToDataMapper<PriceInputData>,
        private val resultMapper: PriceResultDataToDomainMapper<PriceResultDomain>
    ) : PriceInteractor {
        override fun calcTripPrice(input: PriceInputDomain) : PriceResultDomain {
            return repository.calcTripPrice(input.map(inputMapper)).map(resultMapper)
        }
    }
}
