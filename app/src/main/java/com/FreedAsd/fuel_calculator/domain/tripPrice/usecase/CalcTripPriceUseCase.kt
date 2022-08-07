package com.FreedAsd.fuel_calculator.domain.tripPrice.usecase

import com.FreedAsd.fuel_calculator.domain.tripPrice.CalcTripPriceRepository
import com.FreedAsd.fuel_calculator.domain.tripPrice.domainPriceMappers.InputDataDomainMapper
import com.FreedAsd.fuel_calculator.domain.tripPrice.PriceInputDomain
import com.FreedAsd.fuel_calculator.domain.tripPrice.PriceResultDomain
import com.FreedAsd.fuel_calculator.domain.tripPrice.domainPriceMappers.PriceResultDomainMapper

class CalcTripPriceUseCase(
    private val repository: CalcTripPriceRepository,
    private val inputMapper: InputDataDomainMapper,
    private val resultMapper: PriceResultDomainMapper
) {

    fun calcTripPrice(data: PriceInputDomain) : PriceResultDomain {
        return resultMapper.map(repository.calcTripPrice(inputMapper.map(data)))
    }
}
