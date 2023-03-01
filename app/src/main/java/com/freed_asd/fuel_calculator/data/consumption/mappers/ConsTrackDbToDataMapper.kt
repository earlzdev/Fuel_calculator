package com.freed_asd.fuel_calculator.data.consumption.mappers

import com.freed_asd.fuel_calculator.data.consumption.models.SavedTrackConsData
import com.freed_asd.fuel_calculator.data.local.consumption.track.ConsTrack

interface ConsTrackDbToDataMapper<T> {

    fun mapToData(value: ConsTrack) : T

    class Base : ConsTrackDbToDataMapper<SavedTrackConsData> {
        override fun mapToData(value: ConsTrack) =
            SavedTrackConsData.Base(value.id, value.consumption, value.mileage)
    }
}
