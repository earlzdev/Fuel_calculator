package com.freed_asd.fuel_calculator.presentation.statistic.mileage.track.dbModel

import com.freed_asd.fuel_calculator.domain.consumption.models.SavedTrackConsDomain

interface ConsTrackDbItemUi {

    fun <T> mapToDomain(mapper: ConsTrackUiToDomainMapper<T>) : T

    fun id() : Long

    fun cons() : Float

    fun mileage() : Float

    class Base(
        private val id: Long,
        private val consumption: Float,
        private val mileage: Float
    ) : ConsTrackDbItemUi {
        override fun <T> mapToDomain(mapper: ConsTrackUiToDomainMapper<T>) = mapper.mapToDb(id, consumption, mileage)

        override fun id(): Long = id

        override fun cons(): Float = consumption

        override fun mileage(): Float = mileage
    }
}


interface ConsTrackUiToDomainMapper<T> {

    fun mapToDb(id: Long, consumption: Float, mileage: Float) : T

    class Base() : ConsTrackUiToDomainMapper<SavedTrackConsDomain> {

        override fun mapToDb(id: Long, consumption: Float, mileage: Float) = SavedTrackConsDomain.Base(id, consumption, mileage)
    }
}