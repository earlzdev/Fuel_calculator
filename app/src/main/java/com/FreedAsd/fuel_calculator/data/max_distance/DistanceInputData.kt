package com.FreedAsd.fuel_calculator.data.max_distance

interface DistanceInputData {

    fun maxDistance(mapper: MaxDistanceMapper) : Float

    fun tripPrice(mapper: TripPriceMapper) : Float

    data class Base(
        private val fuelConsumption: Float,
        private val amountOfFuel: Float,
        private val fuelPrice: Float
    ) : DistanceInputData {

        override fun maxDistance(mapper: MaxDistanceMapper) : Float {
            return mapper.maxDistance(fuelConsumption, amountOfFuel)
        }

        override fun tripPrice(mapper: TripPriceMapper): Float {
            return mapper.tripPrice(amountOfFuel, fuelPrice)
        }
    }

    interface MaxDistanceMapper {
        fun maxDistance(fuelConsumption: Float, amountOfFuel: Float) : Float {
            return (100 / fuelConsumption) * amountOfFuel
        }
    }

    interface TripPriceMapper {
        fun tripPrice(amountOfFuel: Float, fuelPrice: Float) : Float {
            return amountOfFuel * fuelPrice
        }
    }
}
