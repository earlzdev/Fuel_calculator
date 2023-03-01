package com.freed_asd.fuel_calculator

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelStoreOwner
import com.freed_asd.fuel_calculator.presentation.core.ViewModelFactory
import com.freed_asd.fuel_calculator.sl.Dependencies
import com.freed_asd.fuel_calculator.sl.ViewModelsFactory
import com.freed_asd.fuel_calculator.sl.consumption.ConsCoreModule
import com.freed_asd.fuel_calculator.sl.distance.DistanceCoreModule
import com.freed_asd.fuel_calculator.sl.price.PriceCoreModule

class FuelCalcApp: Application(), ViewModelFactory {

    private lateinit var distanceCoreModule: DistanceCoreModule
    private lateinit var priceCoreModule: PriceCoreModule
    private lateinit var consCoreModule: ConsCoreModule

    override fun onCreate() {
        super.onCreate()

        distanceCoreModule = DistanceCoreModule()
        priceCoreModule = PriceCoreModule()
        consCoreModule = ConsCoreModule()
        distanceCoreModule.init(this)
        priceCoreModule.init(this)
        consCoreModule.init(this)
    }

    override fun provide(): ViewModelProvider.Factory {
        return ViewModelsFactory(
            Dependencies.Base(
                distanceCoreModule,
                priceCoreModule,
                consCoreModule
            )
        )
    }

    fun <T : ViewModel> viewModel(modelClass: Class<T>, owner: ViewModelStoreOwner): T {
        return ViewModelProvider(owner, provide())[modelClass]
    }
}