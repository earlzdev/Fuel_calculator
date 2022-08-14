package com.freed_asd.fuel_calculator.data.distance.dbItem

import com.freed_asd.fuel_calculator.domain.distance.dbItem.DistanceDbItemDomainMapper

class BaseDistanceDbItemDomainMapper : DistanceDbItemDomainMapper<DistanceDbItemData> {

    override fun mapToUi(id: Long, name: String, distance: Float, price: Float): DistanceDbItemData {
        TODO("Not yet implemented")
    }

    override fun mapToData(id: Long, name: String, distance: Float, price: Float): DistanceDbItemData =
        DistanceDbItemData.Base(id, name, distance, price)
}