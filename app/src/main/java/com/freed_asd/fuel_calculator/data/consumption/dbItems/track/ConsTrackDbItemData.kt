package com.freed_asd.fuel_calculator.data.consumption.dbItems.track

import com.freed_asd.fuel_calculator.data.local.consumption.track.ConsTrack
import com.freed_asd.fuel_calculator.domain.consumption.dbItem.track.ConsTrackDbItemDomain

interface ConsTrackDbItemData {

    fun<T> mapToDb(mapper: ConsTrackDataToDbMapper<T>) : T

    fun<T> mapToDomain(mapper: ConsTrackDataToDomainMapper<T>) : T

    class Base(
        private val id: Long,
        private val consumption: Float,
        private val mileage: Float
    ) : ConsTrackDbItemData {
        override fun <T> mapToDb(mapper: ConsTrackDataToDbMapper<T>) = mapper.mapToDb(id, consumption, mileage)

        override fun <T> mapToDomain(mapper: ConsTrackDataToDomainMapper<T>) = mapper.mapToDomain(id, consumption, mileage)
    }
}

interface ConsTrackDataToDbMapper<T> {

    fun mapToDb(id: Long, consumption: Float, mileage: Float) : T

    class Base() : ConsTrackDataToDbMapper<ConsTrack> {

        override fun mapToDb(id: Long, consumption: Float, mileage: Float) = ConsTrack(id, consumption, mileage)
    }
}

interface ConsTrackDataToDomainMapper<T> {

    fun mapToDomain(id: Long, consumption: Float, mileage: Float) : T

    class Base() : ConsTrackDataToDomainMapper<ConsTrackDbItemDomain> {

        override fun mapToDomain(id: Long, consumption: Float, mileage: Float) = ConsTrackDbItemDomain.Base(id, consumption, mileage)
    }
}