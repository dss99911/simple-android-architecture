package com.google.samples.apps.sunflower.di

import com.google.samples.apps.sunflower.data.AppDatabase
import com.google.samples.apps.sunflower.data.GardenPlantingRepository
import com.google.samples.apps.sunflower.data.PlantRepository
import com.google.samples.apps.sunflower.viewmodels.*
import org.koin.android.ext.koin.androidContext
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val koinModuleApp = module {

    viewModel { GardenViewModel() }

    // ViewModel for Result View
    viewModel { GardenPlantingListViewModel(it[0], get()) }

    viewModel { HomeViewPagerViewModel(it[0]) }

    viewModel { PlantDetailViewModel(get(), get(), it[0]) }

    viewModel { PlantListViewModel(get()) }

    single {
        GardenPlantingRepository.getInstance(AppDatabase.getInstance(androidContext()).gardenPlantingDao())
    }

    single {
        PlantRepository.getInstance(AppDatabase.getInstance(androidContext()).plantDao())
    }
}