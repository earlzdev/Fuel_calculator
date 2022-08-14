package com.freed_asd.fuel_calculator.presentation.distance.dbItem

import com.freed_asd.fuel_calculator.domain.distance.dbItem.DistanceDbItemDomainMapper

class BaseDistanceDbItemDomainMapperUI : DistanceDbItemDomainMapper<DistanceDbItemUi> {

    override fun mapToData(id: Long, name: String, distance: Float, price: Float): DistanceDbItemUi {
        TODO("Not yet implemented")
    }

    override fun mapToUi(id: Long, name: String, distance: Float, price: Float) = DistanceDbItemUi.Base(id, name, distance, price)
}