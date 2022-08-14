package com.freed_asd.fuel_calculator.data.distance.dbItem

interface DistanceDbItemMapper<T> {

    fun map(id: Long, name: String, distance: Float, price: Float) : T
}