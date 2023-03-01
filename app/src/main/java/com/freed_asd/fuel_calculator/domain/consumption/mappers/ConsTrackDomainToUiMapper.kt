package com.freed_asd.fuel_calculator.domain.consumption.mappers

import com.freed_asd.fuel_calculator.presentation.statistic.mileage.track.dbModel.ConsTrackDbItemUi

interface ConsTrackDomainToUiMapper<T> {

    fun mapToDomain(id: Long, consumption: Float, mileage: Float) : T

    class Base : ConsTrackDomainToUiMapper<ConsTrackDbItemUi> {

        override fun mapToDomain(id: Long, consumption: Float, mileage: Float) = ConsTrackDbItemUi.Base(id, consumption, mileage)
    }
}