package com.freed_asd.fuel_calculator.data.local.consumption.mixed

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(
    tableName = "ConsMixedDB"
)
data class ConsMixed (
    @PrimaryKey(autoGenerate = true) val id: Long,
    @ColumnInfo(name = "consumption")val consumption: Float,
    @ColumnInfo(name = "mileage")val mileage: Float
)