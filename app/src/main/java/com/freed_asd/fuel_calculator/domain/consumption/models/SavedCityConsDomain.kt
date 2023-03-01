package com.freed_asd.fuel_calculator.domain.consumption.models

import com.freed_asd.fuel_calculator.domain.distance.mappers.ConsCityDomainToDataMapper
import com.freed_asd.fuel_calculator.domain.distance.mappers.ConsCityDomainToUiMapper

interface SavedCityConsDomain {

    fun <T> mapToData(mapper: ConsCityDomainToDataMapper<T>) : T

    fun <T> mapToUi(mapper: ConsCityDomainToUiMapper<T>) : T

    class Base(
        val id: Long,
        val consumption: Float,
        val mileage: Float
    ) : SavedCityConsDomain {

        override fun <T> mapToData(mapper: ConsCityDomainToDataMapper<T>) = mapper.mapToData(id, consumption, mileage)

        override fun <T> mapToUi(mapper: ConsCityDomainToUiMapper<T>) = mapper.mapToUi(id, consumption, mileage)
    }
}