package com.freedasd.fuel_calculator.domain.consumption.interactor

import com.freedasd.fuel_calculator.data.consumption.mappers.BaseConsInputDomainToDataMapper
import com.freedasd.fuel_calculator.domain.consumption.ConsInputDomain
import com.freedasd.fuel_calculator.domain.consumption.ConsResultDomain
import com.freedasd.fuel_calculator.domain.consumption.ConsumptionRepository
import com.freedasd.fuel_calculator.domain.consumption.mappers.BaseConsResultDataToDomainMapper

interface ConsInteractor {

    fun calcConsumption(input: ConsInputDomain) : ConsResultDomain

    class Base(
        private val repository: ConsumptionRepository,
        private val inputMapper: BaseConsInputDomainToDataMapper,
        private val resultMapper: BaseConsResultDataToDomainMapper
    ) : ConsInteractor {
        override fun calcConsumption(input: ConsInputDomain) : ConsResultDomain {
            return repository.calcConsumption(input.map(inputMapper)).map(resultMapper)
        }
    }
}