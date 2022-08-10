package com.freed_asd.fuel_calculator.presentation.consumption.screens.distance

import android.widget.TextView
import com.freed_asd.fuel_calculator.R

interface ConsDistanceValidation {

    fun validate(): Boolean

    class Base(
        private val distance: TextView,
        private val filledFuel: TextView
    ): ConsDistanceValidation {

        val context = distance.context

        override fun validate(): Boolean {
            val errorMsg = context.getString(R.string.empty_error_msg)

            return when {
                distance.text.isEmpty() -> {
                    distance.error = errorMsg
                    false
                }
                filledFuel.text.isEmpty() -> {
                    filledFuel.error = errorMsg
                    false
                }
                else -> true
            }
        }
    }
}