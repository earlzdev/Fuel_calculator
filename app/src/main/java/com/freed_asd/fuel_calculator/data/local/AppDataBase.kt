package com.freed_asd.fuel_calculator.data.local

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.freed_asd.fuel_calculator.data.local.consumption.city.ConsCity
import com.freed_asd.fuel_calculator.data.local.consumption.city.ConsCityDao
import com.freed_asd.fuel_calculator.data.local.consumption.mixed.ConsMixed
import com.freed_asd.fuel_calculator.data.local.consumption.mixed.ConsMixedDao
import com.freed_asd.fuel_calculator.data.local.consumption.track.ConsTrack
import com.freed_asd.fuel_calculator.data.local.consumption.track.ConsTrackDao
import com.freed_asd.fuel_calculator.data.local.distance.DistanceDao
import com.freed_asd.fuel_calculator.data.local.distance.DistanceDb
import com.freed_asd.fuel_calculator.data.local.price.PriceDao
import com.freed_asd.fuel_calculator.data.local.price.PriceDb

@Database(entities = [ConsCity::class, ConsMixed::class, ConsTrack::class, PriceDb::class, DistanceDb::class], version = 4)
abstract class AppDataBase : RoomDatabase() {

    abstract fun cityDao() : ConsCityDao

    abstract fun trackDao() : ConsTrackDao

    abstract fun mixedDao() : ConsMixedDao

    abstract fun distanceDao() : DistanceDao

    abstract fun priceDao() : PriceDao

    companion object {

        @Volatile
        private var INSTANCE: AppDataBase? = null

        fun localDataBase(context: Context) : AppDataBase {
            val tempInstance = INSTANCE
            if (tempInstance != null) {
                return tempInstance
            }
            synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    AppDataBase::class.java,
                    "consumption_dataBase"
                )
                    .fallbackToDestructiveMigration()
                    .build()
                INSTANCE = instance
                return instance
            }
        }
    }
}