package com.freed_asd.fuel_calculator.data.consumption.mappers

import com.freed_asd.fuel_calculator.domain.consumption.models.SavedTrackConsDomain

interface ConsTrackDataToDomainMapper<T> {

    fun mapToDomain(id: Long, consumption: Float, mileage: Float) : T

    class Base : ConsTrackDataToDomainMapper<SavedTrackConsDomain> {

        override fun mapToDomain(id: Long, consumption: Float, mileage: Float) = SavedTrackConsDomain.Base(id, consumption, mileage)
    }
}