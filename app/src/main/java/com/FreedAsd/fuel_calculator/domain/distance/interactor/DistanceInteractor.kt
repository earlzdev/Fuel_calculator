package com.freedasd.fuel_calculator.domain.distance.interactor

import com.freedasd.fuel_calculator.data.distance.DistanceInputData
import com.freedasd.fuel_calculator.data.distance.mappers.ResultDataToDomainMapper
import com.freedasd.fuel_calculator.domain.distance.CalcMaxDistanceRepository
import com.freedasd.fuel_calculator.domain.distance.DistanceInputDomain
import com.freedasd.fuel_calculator.domain.distance.DistanceResultDomain
import com.freedasd.fuel_calculator.domain.distance.mappers.InputDomainToDataMapper

interface DistanceInteractor {

    fun calcMaxDistance(data: DistanceInputDomain) : DistanceResultDomain

    class Base(
        private val repository: CalcMaxDistanceRepository,
        private val inputMapper: InputDomainToDataMapper<DistanceInputData>,
        private val resultMapper: ResultDataToDomainMapper<DistanceResultDomain>
    ) : DistanceInteractor {
        override fun calcMaxDistance(data: DistanceInputDomain): DistanceResultDomain =
            repository.calcMaxDistance(data.map(inputMapper)).map(resultMapper)
    }
}