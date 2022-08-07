package com.freed_asd.fuel_calculator.presentation.distance

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

interface DistanceResultUi {

    fun distance() : Float

    fun price() : Float

    @Parcelize
    class Base(
        private val maxDistance: Float,
        private val tripPrice: Float
    ) : DistanceResultUi, Parcelable {
        override fun distance() = maxDistance
        override fun price() = tripPrice
    }
}