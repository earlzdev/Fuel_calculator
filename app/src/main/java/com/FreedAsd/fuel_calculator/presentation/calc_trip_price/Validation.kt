package com.FreedAsd.fuel_calculator.presentation.calc_trip_price

import android.widget.EditText
import com.FreedAsd.fuel_calculator.R

interface Validation {

    fun validate(): Boolean

    class Base(
        private val fuelConsumption: EditText,
        private val distance: EditText,
        private val fuelPrice: EditText,
    ): Validation {

        private val context = fuelConsumption.context

        override fun validate(): Boolean {
            val emptyErrorMsg = context.getString(R.string.empty_error_msg)
            return when {
                fuelConsumption.text.isEmpty() -> {
                    fuelConsumption.error = emptyErrorMsg
                    false
                }
                distance.text.isEmpty() -> {
                    distance.error = emptyErrorMsg
                    false
                }
                fuelPrice.text.isEmpty() -> {
                    fuelPrice.error = emptyErrorMsg
                    false
                }
                else -> true
            }
        }
    }
}