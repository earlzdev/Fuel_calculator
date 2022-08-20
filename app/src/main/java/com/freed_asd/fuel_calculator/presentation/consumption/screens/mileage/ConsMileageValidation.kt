package com.freed_asd.fuel_calculator.presentation.consumption.screens.mileage

import android.widget.TextView
import com.freed_asd.fuel_calculator.R

interface ConsMileageValidation {

    fun validate() : Boolean

    class Base(
        private val currentMileage: TextView,
        private val previousMileage: TextView,
        private val filledFuel: TextView
    ) : ConsMileageValidation {

        val context = currentMileage.context

        override fun validate(): Boolean {

            val errorMsg = context.getString(R.string.empty_error_msg)

            return when {
                currentMileage.text.isEmpty() -> {
                    currentMileage.error = errorMsg
                    false
                }
                previousMileage.text.isEmpty() -> {
                    previousMileage.error = errorMsg
                    false
                }
                filledFuel.text.isEmpty() -> {
                    filledFuel.error = errorMsg
                    false
                }
                currentMileage.text == previousMileage.text -> {
                    currentMileage.error = context.getString(R.string.values_cannot_be_same)
                    false
                }
                else -> true
            }
        }
    }
}