package com.FreedAsd.fuel_calculator.domain.calc_fuel_price.usecase

import com.FreedAsd.fuel_calculator.domain.calc_fuel_price.CalcTripPriceRepository
import com.FreedAsd.fuel_calculator.domain.calc_fuel_price.domainPriceMappers.InputDataDomainMapper
import com.FreedAsd.fuel_calculator.domain.calc_fuel_price.PriceInputDomain
import com.FreedAsd.fuel_calculator.domain.calc_fuel_price.PriceResultDomain
import com.FreedAsd.fuel_calculator.domain.calc_fuel_price.domainPriceMappers.PriceResultDomainMapper

class CalcTripPriceUseCase(
    private val repository: CalcTripPriceRepository,
    private val inputMapper: InputDataDomainMapper,
    private val resultMapper: PriceResultDomainMapper
) {

    fun calcTripPrice(data: PriceInputDomain) : PriceResultDomain {
        return resultMapper.map(repository.calcTripPrice(inputMapper.map(data)))
    }
}
