package com.freed_asd.fuel_calculator.presentation.consumption.screens.mileage

import android.widget.CheckBox
import android.widget.Spinner

interface ShouldAddIntoStats {

    fun shouldlAddIntoStats() : Boolean

    class Base(
        private val checkBox: CheckBox,
    ) : ShouldAddIntoStats {

        override fun shouldlAddIntoStats() = checkBox.isChecked
    }
}