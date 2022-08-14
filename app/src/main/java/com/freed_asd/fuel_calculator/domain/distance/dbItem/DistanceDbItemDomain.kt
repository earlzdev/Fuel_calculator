package com.freed_asd.fuel_calculator.domain.distance.dbItem

interface DistanceDbItemDomain {

    fun <T> mapToData(mapper: DistanceDbItemDomainMapper<T>) : T

    fun <T> mapToUi(mapper: DistanceDbItemDomainMapper<T>) : T

    class Base(
        private val id: Long,
        private val name: String,
        private val distance: Float,
        private val price: Float
    ) : DistanceDbItemDomain {

        override fun <T> mapToData(mapper: DistanceDbItemDomainMapper<T>) = mapper.mapToData(id, name, distance, price)

        override fun <T> mapToUi(mapper: DistanceDbItemDomainMapper<T>) = mapper.mapToUi(id, name, distance, price)
    }
}