package com.freed_asd.fuel_calculator.data.consumption.dbItems.track

import com.freed_asd.fuel_calculator.data.local.consumption.track.ConsTrack

interface ConsTrackDbToDataMapper<T> {

    fun mapToData(value: ConsTrack) : T

    class Base() : ConsTrackDbToDataMapper<ConsTrackDbItemData> {
        override fun mapToData(value: ConsTrack) = ConsTrackDbItemData.Base(value.id, value.consumption, value.mileage)
    }
}
