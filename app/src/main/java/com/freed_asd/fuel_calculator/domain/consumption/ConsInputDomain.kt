package com.freed_asd.fuel_calculator.domain.consumption

import com.freed_asd.fuel_calculator.domain.consumption.mappers.ConsInputDomainToDataMapper

interface ConsInputDomain {

    fun <T> map(mapper: ConsInputDomainToDataMapper<T>) : T

    class Base(
<<<<<<< HEAD
        private val distance: Float,
        private val filledFuel: Float
    ) : ConsInputDomain {
        override fun <T> map(mapper: ConsInputDomainToDataMapper<T>) =
            mapper.map(distance, filledFuel)
=======
        private val currentMileage: Float,
        private val previousMileage: Float,
        private val filledFuel: Float
    ) : ConsInputDomain {
        override fun <T> map(mapper: ConsInputDomainToDataMapper<T>) =
            mapper.map(currentMileage, previousMileage, filledFuel)
>>>>>>> master
    }
}