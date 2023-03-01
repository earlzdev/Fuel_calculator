package com.freed_asd.fuel_calculator.domain.distance.mappers

import com.freed_asd.fuel_calculator.presentation.statistic.mileage.city.dbModel.ConsCityDbItemUi

interface ConsCityDomainToUiMapper <T> {

    fun mapToUi(id: Long, consumption: Float, mileage: Float) : T

    class Base() : ConsCityDomainToUiMapper<ConsCityDbItemUi> {
        override fun mapToUi(id: Long, consumption: Float, mileage: Float) = ConsCityDbItemUi.Base(id, consumption, mileage)
    }
}