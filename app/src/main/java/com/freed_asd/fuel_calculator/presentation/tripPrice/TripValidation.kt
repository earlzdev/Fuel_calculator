package com.freed_asd.fuel_calculator.presentation.tripPrice

import android.widget.EditText
import com.freed_asd.fuel_calculator.R

interface TripValidation {

    fun validate(): Boolean

    class Base(
        private val fuelConsumption: EditText,
        private val distance: EditText,
        private val fuelPrice: EditText,
    ): TripValidation {

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