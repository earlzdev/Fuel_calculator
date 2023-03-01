package com.freed_asd.fuel_calculator.domain.consumption.mappers

import com.freed_asd.fuel_calculator.presentation.statistic.mileage.mixed.dbModel.ConsMixedDbItemUi

interface ConsMixedDomainToUiMapper<T> {

    fun mapToUi(id: Long, consumption: Float, mileage: Float) : T

    class Base : ConsMixedDomainToUiMapper<ConsMixedDbItemUi> {
        override fun mapToUi(id: Long, consumption: Float, mileage: Float) = ConsMixedDbItemUi.Base(id, consumption, mileage)
    }
}