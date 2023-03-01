package com.freed_asd.fuel_calculator.data.local.price

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.freed_asd.fuel_calculator.data.tripPrice.models.SavedTripPriceDataToDbMapper
import com.freed_asd.fuel_calculator.data.tripPrice.models.SavedTripPriceDbToDataMapper

@Entity(tableName = "priceDb")
data class PriceDb (
    @PrimaryKey(autoGenerate = true) val id: Long,
    @ColumnInfo(name = "name") val name: String,
    @ColumnInfo(name = "consumption") val distance: Float,
    @ColumnInfo(name = "distance") val needFuel: Float,
    @ColumnInfo(name = "generalPrice") val generalPrice: Float,
    @ColumnInfo(name = "everyonePrice") var everyonePrice: Float
) {
    fun <T> mapToData(mapper: SavedTripPriceDbToDataMapper<T>) = mapper.mapToData(this)
}
