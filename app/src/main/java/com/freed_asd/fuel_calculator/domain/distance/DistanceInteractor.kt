package com.freed_asd.fuel_calculator.domain.distance

import com.freed_asd.fuel_calculator.data.distance.models.CalcMaxDistanceValuesData
import com.freed_asd.fuel_calculator.data.distance.mappers.ResultDataToDomainMapper
import com.freed_asd.fuel_calculator.domain.distance.mappers.InputDomainToDataMapper
import com.freed_asd.fuel_calculator.domain.distance.models.CalcMaxDistanceResultDomain
import com.freed_asd.fuel_calculator.domain.distance.models.CalcMaxDistanceValuesDomain

interface DistanceInteractor {

    fun calcMaxDistance(data: CalcMaxDistanceValuesDomain) : CalcMaxDistanceResultDomain

    class Base(
        private val repository: CalcMaxDistanceRepository,
        private val inputMapper: InputDomainToDataMapper<CalcMaxDistanceValuesData>,
        private val resultMapper: ResultDataToDomainMapper<CalcMaxDistanceResultDomain>,
    ) : DistanceInteractor {

        override fun calcMaxDistance(data: CalcMaxDistanceValuesDomain): CalcMaxDistanceResultDomain =
            repository.calcMaxDistance(data.map(inputMapper)).map(resultMapper)
    }
}