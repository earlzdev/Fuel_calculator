package com.freed_asd.fuel_calculator.data.consumption.mappers

import com.freed_asd.fuel_calculator.data.local.consumption.track.ConsTrack

interface ConsTrackDataToDbMapper<T> {

    fun mapToDb(id: Long, consumption: Float, mileage: Float) : T

    class Base : ConsTrackDataToDbMapper<ConsTrack> {

        override fun mapToDb(id: Long, consumption: Float, mileage: Float) = ConsTrack(id, consumption, mileage)
    }
}