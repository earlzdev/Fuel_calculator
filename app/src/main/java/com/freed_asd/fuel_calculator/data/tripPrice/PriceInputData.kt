package com.freed_asd.fuel_calculator.data.tripPrice

<<<<<<< HEAD
data class PriceInputData (
    val averageConsumption: Float,
    val distance: Float,
    var fuelPrice: Float = 1f,
    var passengersCount: Float = 1f
)
=======
interface PriceInputData {

    fun onePersonPrice() : Float

    fun generalPrice() : Float

    fun needFuel() : Float

    fun distance() : Float

    fun passengers() : Float

    class Base(
        private val averageConsumption: Float,
        private val distance: Float,
        private var fuelPrice: Float = 1f,
        private var passengersCount: Float = 1f
    ): PriceInputData {

        override fun onePersonPrice() =
            (((distance / 100)
                    * averageConsumption)
                    * fuelPrice) / passengersCount

        override fun generalPrice() =
            (((distance / 100)
                    * averageConsumption)
                    * fuelPrice)

        override fun needFuel() = (distance / 100) * averageConsumption

        override fun distance() = distance

        override fun passengers() = passengersCount
    }
}
>>>>>>> master
