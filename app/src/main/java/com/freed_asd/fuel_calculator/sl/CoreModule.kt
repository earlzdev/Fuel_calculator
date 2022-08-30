package com.freed_asd.fuel_calculator.sl

import android.content.Context
import com.freed_asd.fuel_calculator.data.local.AppDataBase

class CoreModule {

    lateinit var resourceProvider: ResourceProvider

    fun init(context: Context) {
        val appDb = AppDataBase.localDataBase(context)
        resourceProvider = ResourceProvider.Base(context)
    }
}