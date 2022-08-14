package com.freed_asd.fuel_calculator.data.local.distance

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(
    tableName = "distanceDb"
)
data class DistanceDb (

    @PrimaryKey(autoGenerate = true)  val id: Long,
    @ColumnInfo(name = "name") val name: String,
    @ColumnInfo(name = "distance") val distance: Float,
    @ColumnInfo(name = "price") val price: Float
)