package com.freed_asd.fuel_calculator.presentation.tripPrice

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

<<<<<<< HEAD
@Parcelize
data class PriceResultUi(
    val distance: Float,
    val needFuel: Float,
    val generalTripPrice: Float,
    val everyoneTripPrice: Float,
    val passengers: Float
): Parcelable
=======
interface PriceResultUi {

    fun distance() : Float

    fun needFuel() : Float

    fun generalPrice() : Float

    fun everyonePrice() : Float

    fun passengers() : Float

    @Parcelize
    class Base(
        private val distance: Float,
        private val needFuel: Float,
        private val generalTripPrice: Float,
        private val everyoneTripPrice: Float,
        private val passengers: Float
    ) : PriceResultUi, Parcelable {
        override fun distance() = distance

        override fun needFuel() = needFuel

        override fun generalPrice() = generalTripPrice

        override fun everyonePrice() = everyoneTripPrice

        override fun passengers() = passengers
    }
}
>>>>>>> master
