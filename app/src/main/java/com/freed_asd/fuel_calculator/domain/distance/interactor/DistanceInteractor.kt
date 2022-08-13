package com.freed_asd.fuel_calculator.domain.distance.interactor

import com.freed_asd.fuel_calculator.data.distance.DistanceInputData
import com.freed_asd.fuel_calculator.data.distance.mappers.ResultDataToDomainMapper
import com.freed_asd.fuel_calculator.data.local.distance.DistanceDb
import com.freed_asd.fuel_calculator.domain.distance.CalcMaxDistanceRepository
import com.freed_asd.fuel_calculator.domain.distance.DistanceInputDomain
import com.freed_asd.fuel_calculator.domain.distance.DistanceResultDomain
import com.freed_asd.fuel_calculator.domain.distance.mappers.InputDomainToDataMapper

interface DistanceInteractor {

    fun calcMaxDistance(data: DistanceInputDomain) : DistanceResultDomain

    suspend fun insertIntoDb(distance: Float, price: Float)

    class Base(
        private val repository: CalcMaxDistanceRepository,
        private val inputMapper: InputDomainToDataMapper<DistanceInputData>,
        private val resultMapper: ResultDataToDomainMapper<DistanceResultDomain>
    ) : DistanceInteractor {

        override fun calcMaxDistance(data: DistanceInputDomain): DistanceResultDomain =
            repository.calcMaxDistance(data.map(inputMapper)).map(resultMapper)

        override suspend fun insertIntoDb(distance: Float, price: Float) =
            repository.insertIntoDb(
                DistanceDb(0, distance, price)
            )
    }
}