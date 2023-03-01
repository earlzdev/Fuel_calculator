package com.freed_asd.fuel_calculator.domain.consumption.models

import com.freed_asd.fuel_calculator.domain.consumption.mappers.ConsMixedDomainToDataMapper
import com.freed_asd.fuel_calculator.domain.consumption.mappers.ConsMixedDomainToUiMapper

interface SavedMixedDomain {

    fun <T> mapToData(mapper: ConsMixedDomainToDataMapper<T>) :T

    fun <T> mapToUi(mapper: ConsMixedDomainToUiMapper<T>) : T

    fun id() : Long

    fun cons() : Float

    fun mileage() : Float

    class Base(
        val id: Long,
        val consumption: Float,
        val mileage: Float
    ) : SavedMixedDomain {

        override fun <T> mapToData(mapper: ConsMixedDomainToDataMapper<T>) = mapper.mapToData(id, consumption, mileage)

        override fun <T> mapToUi(mapper: ConsMixedDomainToUiMapper<T>) = mapper.mapToUi(id, consumption, mileage)

        override fun id(): Long = id

        override fun cons(): Float = consumption

        override fun mileage(): Float = mileage
    }
}