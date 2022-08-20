package com.freed_asd.fuel_calculator.data.consumption.dbItems.mixed

import com.freed_asd.fuel_calculator.data.local.consumption.mixed.ConsMixed

interface ConsMixedDbToDataMapper<T> {

    fun mapToData(item: ConsMixed) : T

    class Base() : ConsMixedDbToDataMapper<ConsMixedDbItemData> {
        override fun mapToData(item: ConsMixed) = ConsMixedDbItemData.Base(item.id, item.consumption, item.mileage)
    }
}