package com.freed_asd.fuel_calculator.domain.consumption.dbItem.track

import com.freed_asd.fuel_calculator.data.consumption.dbItems.track.ConsTrackDbItemData
import com.freed_asd.fuel_calculator.presentation.statistic.mileage.track.dbModel.ConsTrackDbItemUi

interface ConsTrackDbItemDomain {

    fun <T> mapToData(mapper: ConsTrackDomainToData<T>) : T

    fun <T> mapToUi(mapper: ConsTrackDomainToUiMapper<T>) : T

    class Base(
        private val id: Long,
        private val consumption: Float,
        private val mileage: Float
    ) : ConsTrackDbItemDomain {
        override fun <T> mapToData(mapper: ConsTrackDomainToData<T>) = mapper.mapToDb(id, consumption, mileage)

        override fun <T> mapToUi(mapper: ConsTrackDomainToUiMapper<T>) = mapper.mapToDomain(id, consumption, mileage)
    }
}

interface ConsTrackDomainToData<T> {

    fun mapToDb(id: Long, consumption: Float, mileage: Float) : T

    class Base() : ConsTrackDomainToData<ConsTrackDbItemData> {

        override fun mapToDb(id: Long, consumption: Float, mileage: Float) = ConsTrackDbItemData.Base(id, consumption, mileage)
    }
}

interface ConsTrackDomainToUiMapper<T> {

    fun mapToDomain(id: Long, consumption: Float, mileage: Float) : T

    class Base() : ConsTrackDomainToUiMapper<ConsTrackDbItemUi> {

        override fun mapToDomain(id: Long, consumption: Float, mileage: Float) = ConsTrackDbItemUi.Base(id, consumption, mileage)
    }
}