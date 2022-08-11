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

@Database(entities = [ConsCity::class, ConsMixed::class, ConsTrack::class], version = 1)
abstract class AppDataBase : RoomDatabase() {

    abstract fun cityDao() : ConsCityDao

    abstract fun trackDao() : ConsTrackDao

    abstract fun mixedDao() : ConsMixedDao

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
                ).build()
                INSTANCE = instance
                return instance
            }
        }
    }
}