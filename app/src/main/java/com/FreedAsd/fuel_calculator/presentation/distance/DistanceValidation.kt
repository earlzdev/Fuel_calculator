package com.FreedAsd.fuel_calculator.presentation.distance

import android.widget.EditText
import com.FreedAsd.fuel_calculator.R
import com.FreedAsd.fuel_calculator.presentation.tripPrice.TripValidation

interface DistanceValidation {

    fun validate(): Boolean

    class Base(
        private val fuelConsumption: EditText,
        private val amountOfFuel: EditText,
        private val fuelPrice: EditText
    ) : TripValidation {

        private val context = fuelConsumption.context

        override fun validate(): Boolean {
            val emptyErrorMsg = context.getString(R.string.empty_error_msg)
            return when {
                fuelConsumption.text.isEmpty() -> {
                    fuelConsumption.error = emptyErrorMsg
                    false
                }
                amountOfFuel.text.isEmpty() -> {
                    amountOfFuel.error = emptyErrorMsg
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