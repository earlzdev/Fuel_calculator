package com.freed_asd.fuel_calculator.presentation.statistic.mileage.mixed.dbModel

import com.freed_asd.fuel_calculator.domain.consumption.models.SavedMixedDomain

interface ConsMixedDbItemUi {

    fun <T> mapToDomain(mapper: ConsMixedUiToDomainMapper<T>) : T

    fun id() : Long

    fun cons() : Float

    fun mileage() : Float

    class Base(
        val id: Long,
        val consumption: Float,
        val mileage: Float
    ) : ConsMixedDbItemUi {

        override fun <T> mapToDomain(mapper: ConsMixedUiToDomainMapper<T>) = mapper.mapToUi(id, consumption, mileage)

        override fun id(): Long = id

        override fun cons(): Float = consumption

        override fun mileage(): Float = mileage
    }
}

interface ConsMixedUiToDomainMapper<T> {

    fun mapToUi(id: Long, consumption: Float, mileage: Float) : T

    class Base() : ConsMixedUiToDomainMapper<SavedMixedDomain> {
        override fun mapToUi(id: Long, consumption: Float, mileage: Float) = SavedMixedDomain.Base(id, consumption, mileage)
    }
}