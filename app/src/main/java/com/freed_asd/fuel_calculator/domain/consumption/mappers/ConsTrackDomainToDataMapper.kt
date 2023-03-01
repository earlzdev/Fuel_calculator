package com.freed_asd.fuel_calculator.domain.consumption.mappers

import com.freed_asd.fuel_calculator.data.consumption.models.SavedTrackConsData

interface ConsTrackDomainToDataMapper<T> {

    fun mapToDb(id: Long, consumption: Float, mileage: Float) : T

    class Base : ConsTrackDomainToDataMapper<SavedTrackConsData> {

        override fun mapToDb(id: Long, consumption: Float, mileage: Float) = SavedTrackConsData.Base(id, consumption, mileage)
    }
}