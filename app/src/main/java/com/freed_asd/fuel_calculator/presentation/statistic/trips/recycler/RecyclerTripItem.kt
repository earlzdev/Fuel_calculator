package com.freed_asd.fuel_calculator.presentation.statistic.trips.recycler

data class RecyclerTripItem (
    val id: Long,
    val name: String,
    val info: String,
    val image: Int,
    val type: ItemType
)