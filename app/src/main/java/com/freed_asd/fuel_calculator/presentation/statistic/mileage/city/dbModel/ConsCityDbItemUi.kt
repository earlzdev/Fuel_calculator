package com.freed_asd.fuel_calculator.presentation.statistic.mileage.city.dbModel

import com.freed_asd.fuel_calculator.domain.consumption.dbItem.city.ConsCityDbItemDomain

interface ConsCityDbItemUi {

    fun <T> mapToDomain(mapper: ConsCityUiToDomainMapper<T>) : T

    fun id() : Long

    fun cons() : Float

    fun mileage() : Float

    class Base(
        val id: Long,
        val consumption: Float,
        val mileage: Float
    ) : ConsCityDbItemUi {
        override fun <T> mapToDomain(mapper: ConsCityUiToDomainMapper<T>) = mapper.mapToUi(id, consumption, mileage)

        override fun id(): Long = id

        override fun cons(): Float = consumption

        override fun mileage(): Float = mileage
    }
}

interface ConsCityUiToDomainMapper <T> {

    fun mapToUi(id: Long, consumption: Float, mileage: Float) : T

    class Base() : ConsCityUiToDomainMapper<ConsCityDbItemDomain> {
        override fun mapToUi(id: Long, consumption: Float, mileage: Float) = ConsCityDbItemDomain.Base(id, consumption, mileage)
    }
}