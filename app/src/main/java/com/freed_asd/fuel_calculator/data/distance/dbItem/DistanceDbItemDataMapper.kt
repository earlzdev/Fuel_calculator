package com.freed_asd.fuel_calculator.data.distance.dbItem

interface DistanceDbItemDataMapper<T> {

    fun map(id: Long, name: String, distance: Float, price: Float) : T
}