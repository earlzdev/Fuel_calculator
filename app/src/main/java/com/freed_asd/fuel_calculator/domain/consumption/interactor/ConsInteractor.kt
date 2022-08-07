package com.freed_asd.fuel_calculator.domain.consumption.interactor

import com.freed_asd.fuel_calculator.data.consumption.mappers.BaseConsInputDomainToDataMapper
import com.freed_asd.fuel_calculator.domain.consumption.ConsInputDomain
import com.freed_asd.fuel_calculator.domain.consumption.ConsResultDomain
import com.freed_asd.fuel_calculator.domain.consumption.ConsumptionRepository
import com.freed_asd.fuel_calculator.domain.consumption.mappers.BaseConsResultDataToDomainMapper

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