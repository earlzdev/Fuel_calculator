package com.freed_asd.fuel_calculator.presentation.distance.dbItem

interface DistanceDbItemUiMapper <T> {

    fun map(id: Long, name: String, distance: Float, price: Float) : T
}