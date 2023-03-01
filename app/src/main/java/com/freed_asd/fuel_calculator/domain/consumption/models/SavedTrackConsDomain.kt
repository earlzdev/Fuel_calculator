package com.freed_asd.fuel_calculator.domain.consumption.models

import com.freed_asd.fuel_calculator.domain.consumption.mappers.ConsTrackDomainToDataMapper
import com.freed_asd.fuel_calculator.domain.consumption.mappers.ConsTrackDomainToUiMapper

interface SavedTrackConsDomain {

    fun <T> mapToData(mapper: ConsTrackDomainToDataMapper<T>) : T

    fun <T> mapToUi(mapper: ConsTrackDomainToUiMapper<T>) : T

    class Base(
        private val id: Long,
        private val consumption: Float,
        private val mileage: Float
    ) : SavedTrackConsDomain {

        override fun <T> mapToData(mapper: ConsTrackDomainToDataMapper<T>) = mapper.mapToDb(id, consumption, mileage)

        override fun <T> mapToUi(mapper: ConsTrackDomainToUiMapper<T>) = mapper.mapToDomain(id, consumption, mileage)
    }
}