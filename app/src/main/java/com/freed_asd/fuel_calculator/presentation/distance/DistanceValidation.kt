package com.freed_asd.fuel_calculator.presentation.distance

import android.widget.EditText
import com.freed_asd.fuel_calculator.R

interface DistanceValidation {

    fun validate(): Boolean

    class Base(
        private val fuelConsumption: EditText,
        private val amountOfFuel: EditText,
        private val fuelPrice: EditText
    ) : DistanceValidation {

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