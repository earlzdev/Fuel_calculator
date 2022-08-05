package com.FreedAsd.fuel_calculator.domain.max_distance.usecases

import com.FreedAsd.fuel_calculator.data.max_distance.DistanceInputData
import com.FreedAsd.fuel_calculator.data.max_distance.DistanceResultData
import com.FreedAsd.fuel_calculator.domain.max_distance.CalcMaxDistanceRepository
import com.FreedAsd.fuel_calculator.domain.max_distance.DistanceInputDomain
import com.FreedAsd.fuel_calculator.domain.max_distance.DistanceResultDomain

interface Interactor {

    fun calcMaxDistance(data: DistanceInputDomain) : DistanceResultDomain

    class Base(
        private val repository: CalcMaxDistanceRepository,
        private val inputMapper: DistanceInputDomain.Mapper<DistanceInputData>,
        private val resultMapper: DistanceResultData.Mapper<DistanceResultDomain>
    ) : Interactor {
        override fun calcMaxDistance(data: DistanceInputDomain): DistanceResultDomain =
            repository.calcMaxDistance(data.map(inputMapper)).map(resultMapper)
    }
}