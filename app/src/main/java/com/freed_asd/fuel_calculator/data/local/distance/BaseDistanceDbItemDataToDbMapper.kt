package com.freed_asd.fuel_calculator.data.local.distance

import com.freed_asd.fuel_calculator.data.distance.dbItem.DistanceDbItemMapper

class BaseDistanceDbItemDataToDbMapper : DistanceDbItemMapper<DistanceDb> {

    override fun map(id: Long, name: String, distance: Float, price: Float) =
        DistanceDb(id, name, distance, price)
}