package com.freed_asd.fuel_calculator.domain.tripPrice.models

import com.freed_asd.fuel_calculator.domain.tripPrice.mappers.SavedTripPriceDomainToDataMapper

interface SavedTripPriceDomain {

    fun <T> mapToUi(mapper: PriceItemDbDomainMapper<T>) : T

    fun <T> mapToData(mapper: SavedTripPriceDomainToDataMapper<T>) : T

    class Base(
        private val id: Long,
        private val name: String,
        private val distance: Float,
        private val needFuel: Float,
        private val generalPrice: Float,
        private var everyonePrice: Float
    ) : SavedTripPriceDomain {

        override fun <T> mapToUi(mapper: PriceItemDbDomainMapper<T>) =
            mapper.mapToUi(id, name, distance, needFuel, generalPrice, everyonePrice)

        override fun <T> mapToData(mapper: SavedTripPriceDomainToDataMapper<T>) =
            mapper.map(id, name, distance, needFuel, generalPrice, everyonePrice)
    }
}