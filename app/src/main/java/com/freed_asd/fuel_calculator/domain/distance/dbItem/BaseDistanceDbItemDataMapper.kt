package com.freed_asd.fuel_calculator.domain.distance.dbItem

import com.freed_asd.fuel_calculator.data.distance.dbItem.DistanceDbItemDataMapper

class BaseDistanceDbItemDataMapper : DistanceDbItemDataMapper<DistanceDbItemDomain> {

    override fun map(id: Long, name: String, distance: Float, price: Float) =
        DistanceDbItemDomain.Base(id, name, distance, price)
}