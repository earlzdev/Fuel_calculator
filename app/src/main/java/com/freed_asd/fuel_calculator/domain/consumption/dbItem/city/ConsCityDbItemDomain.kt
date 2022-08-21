package com.freed_asd.fuel_calculator.domain.consumption.dbItem.city

import com.freed_asd.fuel_calculator.data.consumption.dbItems.city.ConsCityDbItemData
import com.freed_asd.fuel_calculator.presentation.statistic.mileage.city.dbModel.ConsCityDbItemUi

interface ConsCityDbItemDomain {

    fun <T> mapToData(mapper: ConsCityDomainToDataMapper<T>) : T

    fun <T> mapToUi(mapper: ConsCityDomainToUiMapper<T>) : T

    class Base(
        val id: Long,
        val consumption: Float,
        val mileage: Float
    ) : ConsCityDbItemDomain {
        override fun <T> mapToData(mapper: ConsCityDomainToDataMapper<T>) = mapper.mapToData(id, consumption, mileage)

        override fun <T> mapToUi(mapper: ConsCityDomainToUiMapper<T>) = mapper.mapToUi(id, consumption, mileage)
    }
}

interface ConsCityDomainToDataMapper <T> {

    fun mapToData(id: Long, consumption: Float, mileage: Float) : T

    class Base() : ConsCityDomainToDataMapper<ConsCityDbItemData> {
        override fun mapToData(id: Long, consumption: Float, mileage: Float) = ConsCityDbItemData.Base(id, consumption, mileage)
    }
}

interface ConsCityDomainToUiMapper <T> {

    fun mapToUi(id: Long, consumption: Float, mileage: Float) : T

    class Base() : ConsCityDomainToUiMapper<ConsCityDbItemUi> {
        override fun mapToUi(id: Long, consumption: Float, mileage: Float) = ConsCityDbItemUi.Base(id, consumption, mileage)
    }
}