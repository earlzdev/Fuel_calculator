package com.FreedAsd.fuel_calculator.presentation.calc_trip_price

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class PriceResultUi(
    val distance: Float,
    val needFuel: Float,
    val generalTripPrice: Float,
    val everyoneTripPrice: Float,
    val passengers: Float
): Parcelable
