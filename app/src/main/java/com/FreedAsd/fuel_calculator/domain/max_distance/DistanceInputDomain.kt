package com.FreedAsd.fuel_calculator.domain.max_distance

import com.FreedAsd.fuel_calculator.data.max_distance.DistanceInputData

interface DistanceInputDomain {

    fun <T> map(mapper: Mapper<T>): T

    fun toDataMap(base: DistanceInputDomain.Base): DistanceInputData.Base

    data class Base(
        private val fuelConsumption: Float,
        private val amountOfFuel: Int,
        private val fuelPrice: Float
    ) : DistanceInputDomain {
        override fun <T> map(mapper: Mapper<T>): T {
            return mapper.map(fuelConsumption, amountOfFuel, fuelPrice)
        }
        override fun toDataMap(base: Base) = DistanceInputData.Base(base.fuelPrice, base.amountOfFuel, base.fuelPrice)
    }

    interface Mapper<T> {
        fun map(consumption: Float, amount: Int, price: Float): T
    }
}