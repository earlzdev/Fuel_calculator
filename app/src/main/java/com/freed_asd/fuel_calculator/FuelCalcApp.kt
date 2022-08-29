package com.freed_asd.fuel_calculator

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelStoreOwner
import com.freed_asd.fuel_calculator.core.ViewModelFactory
import com.freed_asd.fuel_calculator.data.consumption.ConsumptionRepositoryImpl
import com.freed_asd.fuel_calculator.data.consumption.dbItems.city.ConsCityDataToDomainMapper
import com.freed_asd.fuel_calculator.data.consumption.dbItems.city.ConsCityDbToDataMapper
import com.freed_asd.fuel_calculator.data.consumption.dbItems.mixed.ConsMixedDataToDomainMapper
import com.freed_asd.fuel_calculator.data.consumption.dbItems.mixed.ConsMixedDbToDataMapper
import com.freed_asd.fuel_calculator.data.consumption.dbItems.track.ConsTrackDataToDomainMapper
import com.freed_asd.fuel_calculator.data.consumption.dbItems.track.ConsTrackDbToDataMapper
import com.freed_asd.fuel_calculator.data.consumption.mappers.BaseConsInputDomainToDataMapper
import com.freed_asd.fuel_calculator.data.local.AppDataBase
import com.freed_asd.fuel_calculator.data.local.price.BasePriceItemDbMapper
import com.freed_asd.fuel_calculator.data.tripPrice.PriceRepositoryImpl
import com.freed_asd.fuel_calculator.data.tripPrice.dbItem.BasePriceDbITemDomainMapper
import com.freed_asd.fuel_calculator.data.tripPrice.dbItem.BasePriceDbToDataItemMapper
import com.freed_asd.fuel_calculator.data.tripPrice.mappers.BasePriceInputDomainToDataMapper
import com.freed_asd.fuel_calculator.domain.consumption.ConsumptionRepository
import com.freed_asd.fuel_calculator.domain.consumption.dbItem.city.ConsCityDomainToUiMapper
import com.freed_asd.fuel_calculator.domain.consumption.dbItem.mixed.ConsMixedDomainToUiMapper
import com.freed_asd.fuel_calculator.domain.consumption.dbItem.track.ConsTrackDomainToUiMapper
import com.freed_asd.fuel_calculator.domain.consumption.interactor.ConsInteractor
import com.freed_asd.fuel_calculator.domain.consumption.mappers.BaseConsInputUiToDomainMapper
import com.freed_asd.fuel_calculator.domain.consumption.mappers.BaseConsResultDataToDomainMapper
import com.freed_asd.fuel_calculator.domain.distance.mappers.BaseInputUiToDomainMapper
import com.freed_asd.fuel_calculator.domain.tripPrice.dbItem.BasePriceDbItemDataToDomainMapper
import com.freed_asd.fuel_calculator.domain.tripPrice.dbItem.BasePriceDbItemUiMapper
import com.freed_asd.fuel_calculator.domain.tripPrice.interactor.PriceInteractor
import com.freed_asd.fuel_calculator.domain.tripPrice.mappers.BasePriceInputUiToDomainMapper
import com.freed_asd.fuel_calculator.domain.tripPrice.mappers.BasePriceResultDataToDomainMapper
import com.freed_asd.fuel_calculator.presentation.consumption.mappers.BaseConsResultDomainToUiMapper
import com.freed_asd.fuel_calculator.presentation.distance.mappers.BaseResultDomainToUiMapper
import com.freed_asd.fuel_calculator.presentation.price.dbItem.BasePriceDbItemDomainMapperUi
import com.freed_asd.fuel_calculator.presentation.price.mappers.BasePriceResultDomainToUiMapper
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