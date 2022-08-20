package com.freed_asd.fuel_calculator.data.local.consumption.mileage

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "MileageTable")
data class MileageDbModel (
    @PrimaryKey(autoGenerate = true) val id: Long,
    @ColumnInfo(name = "value") val value: Float
)