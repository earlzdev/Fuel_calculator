package com.freed_asd.fuel_calculator.presentation.tripPrice

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
