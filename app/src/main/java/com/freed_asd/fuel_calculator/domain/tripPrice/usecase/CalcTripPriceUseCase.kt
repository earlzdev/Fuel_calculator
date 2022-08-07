package com.freed_asd.fuel_calculator.domain.tripPrice.usecase

import com.freed_asd.fuel_calculator.domain.tripPrice.CalcTripPriceRepository
import com.freed_asd.fuel_calculator.domain.tripPrice.domainPriceMappers.InputDataDomainMapper
import com.freed_asd.fuel_calculator.domain.tripPrice.PriceInputDomain
import com.freed_asd.fuel_calculator.domain.tripPrice.PriceResultDomain
import com.freed_asd.fuel_calculator.domain.tripPrice.domainPriceMappers.PriceResultDomainMapper

class CalcTripPriceUseCase(
    private val repository: CalcTripPriceRepository,
    private val inputMapper: InputDataDomainMapper,
    private val resultMapper: PriceResultDomainMapper
) {

    fun calcTripPrice(data: PriceInputDomain) : PriceResultDomain {
        return resultMapper.map(repository.calcTripPrice(inputMapper.map(data)))
    }
}
