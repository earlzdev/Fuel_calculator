package com.freed_asd.fuel_calculator.data.tripPrice.models

import com.freed_asd.fuel_calculator.data.local.price.PriceDb

interface SavedTripPriceDbToDataMapper<T> {

    fun mapToData(item: PriceDb) : T

    class BaseSavedTripPriceDbToDataMapper : SavedTripPriceDbToDataMapper<PriceDbItemData> {
        override fun mapToData(item: PriceDb) =
            PriceDbItemData.Base(
                item.id,
                item.name,
                item.distance,
                item.needFuel,
                item.generalPrice,
                item.everyonePrice
            )
    }
}