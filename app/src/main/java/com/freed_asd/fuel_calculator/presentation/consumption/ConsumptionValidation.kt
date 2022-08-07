package com.freed_asd.fuel_calculator.presentation.consumption

import android.widget.TextView
import com.freed_asd.fuel_calculator.R

interface ConsumptionValidation {

    fun validate() : Boolean

    class Base(
        private val currentMileage: TextView,
        private val previousMileage: TextView,
        private val filledFuel: TextView
    ) : ConsumptionValidation {

        val context = currentMileage.context

        override fun validate(): Boolean {

            val errorMsg = context.getString(R.string.empty_error_msg)

            return when {
                currentMileage.text.isEmpty() -> {
                    currentMileage.text = errorMsg
                    false
                }
                previousMileage.text.isEmpty() -> {
                    previousMileage.text = errorMsg
                    false
                }
                filledFuel.text.isEmpty() -> {
                    filledFuel.text = errorMsg
                    false
                }
                else -> true
            }
        }
    }
}