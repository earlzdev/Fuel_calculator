package com.freed_asd.fuel_calculator.data.consumption.mappers

import com.freed_asd.fuel_calculator.data.consumption.models.SavedMixedConsData
import com.freed_asd.fuel_calculator.data.local.consumption.mixed.ConsMixed

interface ConsMixedDbToDataMapper<T> {

    fun mapToData(item: ConsMixed) : T

    class Base : ConsMixedDbToDataMapper<SavedMixedConsData> {

        override fun mapToData(item: ConsMixed) =
            SavedMixedConsData.Base(item.id, item.consumption, item.mileage)
    }
}