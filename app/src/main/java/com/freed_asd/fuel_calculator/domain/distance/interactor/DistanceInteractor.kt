package com.freed_asd.fuel_calculator.domain.distance.interactor

import com.freed_asd.fuel_calculator.data.distance.DistanceInputData
import com.freed_asd.fuel_calculator.data.distance.dbItem.DistanceDbItemData
import com.freed_asd.fuel_calculator.data.distance.mappers.ResultDataToDomainMapper
import com.freed_asd.fuel_calculator.domain.distance.CalcMaxDistanceRepository
import com.freed_asd.fuel_calculator.domain.distance.DistanceInputDomain
import com.freed_asd.fuel_calculator.domain.distance.DistanceResultDomain
import com.freed_asd.fuel_calculator.domain.distance.dbItem.DistanceDbItemDomain
import com.freed_asd.fuel_calculator.domain.distance.dbItem.DistanceDbItemDomainMapper
import com.freed_asd.fuel_calculator.domain.distance.mappers.InputDomainToDataMapper

interface DistanceInteractor {

    fun calcMaxDistance(data: DistanceInputDomain) : DistanceResultDomain

    suspend fun insertIntoDb(value: DistanceDbItemDomain)

    class Base(
        private val repository: CalcMaxDistanceRepository,
        private val inputMapper: InputDomainToDataMapper<DistanceInputData>,
        private val resultMapper: ResultDataToDomainMapper<DistanceResultDomain>,
        private val dbDomainMapper: DistanceDbItemDomainMapper<DistanceDbItemData>
    ) : DistanceInteractor {

        override fun calcMaxDistance(data: DistanceInputDomain): DistanceResultDomain =
            repository.calcMaxDistance(data.map(inputMapper)).map(resultMapper)

        override suspend fun insertIntoDb(value: DistanceDbItemDomain) =
            repository.insertIntoDb(value.mapToData(dbDomainMapper))
    }
}