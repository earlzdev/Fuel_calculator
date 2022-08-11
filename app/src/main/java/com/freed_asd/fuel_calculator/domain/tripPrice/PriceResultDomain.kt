package com.freed_asd.fuel_calculator.domain.tripPrice

<<<<<<< HEAD
data class PriceResultDomain (
    val distance: Float,
    val needFuel: Float,
    val generalTripPrice: Float,
    val everyoneTripPrice: Float,
    val passengers: Float
)
=======
import com.freed_asd.fuel_calculator.domain.tripPrice.mappers.PriceResultDomainToUiMapper

interface PriceResultDomain {

    fun <T> map(mapper: PriceResultDomainToUiMapper<T>) : T

    class Base(
        private val distance: Float,
        private val needFuel: Float,
        private val generalTripPrice: Float,
        private val everyoneTripPrice: Float,
        private val passengers: Float
    ) : PriceResultDomain {
        override fun <T> map(mapper: PriceResultDomainToUiMapper<T>) =
            mapper.map(distance, needFuel, generalTripPrice, everyoneTripPrice, passengers)
    }
}
>>>>>>> master
