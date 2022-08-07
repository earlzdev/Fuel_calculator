package com.FreedAsd.fuel_calculator.domain.distance.interactor

import com.FreedAsd.fuel_calculator.data.distance.DistanceInputData
import com.FreedAsd.fuel_calculator.data.distance.DistanceResultData
import com.FreedAsd.fuel_calculator.data.distance.mappers.ResultDataToDomainMapper
import com.FreedAsd.fuel_calculator.domain.distance.CalcMaxDistanceRepository
import com.FreedAsd.fuel_calculator.domain.distance.DistanceInputDomain
import com.FreedAsd.fuel_calculator.domain.distance.DistanceResultDomain
import com.FreedAsd.fuel_calculator.domain.distance.mappers.InputDomainToDataMapper

interface Interactor {

    fun calcMaxDistance(data: DistanceInputDomain) : DistanceResultDomain

    class Base(
        private val repository: CalcMaxDistanceRepository,
        private val inputMapper: InputDomainToDataMapper<DistanceInputData>,
        private val resultMapper: ResultDataToDomainMapper<DistanceResultDomain>
    ) : Interactor {
        override fun calcMaxDistance(data: DistanceInputDomain): DistanceResultDomain =
            repository.calcMaxDistance(data.map(inputMapper)).map(resultMapper)
    }
}