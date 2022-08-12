package com.freed_asd.fuel_calculator.presentation.consumption

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

interface ConsResultUi {

    fun consumption(): Float

    @Parcelize
    class Base(
        private val consumption: Float
    ) : ConsResultUi, Parcelable {

        override fun consumption() = consumption
    }
}