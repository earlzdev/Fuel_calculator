package com.freed_asd.fuel_calculator.domain.distance.dbItem

import com.freed_asd.fuel_calculator.presentation.distance.dbItem.DistanceDbItemUiMapper

class BaseDistanceDbItemUiMapper : DistanceDbItemUiMapper<DistanceDbItemDomain> {

    override fun map(id: Long, name: String, distance: Float, price: Float) =
        DistanceDbItemDomain.Base(id, name, distance, price)
}