package com.freed_asd.fuel_calculator.domain.consumption.dbItem.mixed

import com.freed_asd.fuel_calculator.data.consumption.dbItems.mixed.ConsMixedDbItemData
import com.freed_asd.fuel_calculator.presentation.statistic.mileage.mixed.dbModel.ConsMixedDbItemUi

interface ConsMixedDbItemDomain {

    fun <T> mapToData(mapper: ConsMixedDomainToDataMapper<T>) :T

    fun <T> mapToUi(mapper: ConsMixedDomainToUiMapper<T>) : T

    fun id() : Long

    fun cons() : Float

    fun mileage() : Float

    class Base(
        val id: Long,
        val consumption: Float,
        val mileage: Float
    ) : ConsMixedDbItemDomain {
        override fun <T> mapToData(mapper: ConsMixedDomainToDataMapper<T>) = mapper.mapToData(id, consumption, mileage)

        override fun <T> mapToUi(mapper: ConsMixedDomainToUiMapper<T>) = mapper.mapToUi(id, consumption, mileage)

        override fun id(): Long = id

        override fun cons(): Float = consumption

        override fun mileage(): Float = mileage
    }
}

interface ConsMixedDomainToDataMapper<T> {

    fun mapToData(id: Long, consumption: Float, mileage: Float) : T

    class Base() : ConsMixedDomainToDataMapper<ConsMixedDbItemData> {
        override fun mapToData(id: Long, consumption: Float, mileage: Float) = ConsMixedDbItemData.Base(id, consumption, mileage)
    }
}

interface ConsMixedDomainToUiMapper<T> {

    fun mapToUi(id: Long, consumption: Float, mileage: Float) : T

    class Base() : ConsMixedDomainToUiMapper<ConsMixedDbItemUi> {
        override fun mapToUi(id: Long, consumption: Float, mileage: Float) = ConsMixedDbItemUi.Base(id, consumption, mileage)
    }
}