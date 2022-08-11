package com.freed_asd.fuel_calculator.data.local.consumption.track

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(
    tableName = "ConsTrackDB"
)
data class ConsTrack (
    @PrimaryKey(autoGenerate = true) val id: Long,
    @ColumnInfo(name = "consumption")val consumption: Float,
    @ColumnInfo(name = "mileage")val mileage: Int
)