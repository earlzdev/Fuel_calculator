package com.freed_asd.fuel_calculator.domain.distance.dbItem

interface DistanceDbItemDomainMapper<T> {

    fun mapToData(id: Long, name: String, distance: Float, price: Float) : T

    fun mapToUi(id: Long, name: String, distance: Float, price: Float) : T
}