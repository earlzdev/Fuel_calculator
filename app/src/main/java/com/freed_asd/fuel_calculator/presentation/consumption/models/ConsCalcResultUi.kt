package com.freed_asd.fuel_calculator.presentation.consumption.models

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

interface ConsCalcResultUi {

    fun consumption(): Float

    @Parcelize
    class Base(
        private val consumption: Float
    ) : ConsCalcResultUi, Parcelable {

        override fun consumption() = consumption
    }
}