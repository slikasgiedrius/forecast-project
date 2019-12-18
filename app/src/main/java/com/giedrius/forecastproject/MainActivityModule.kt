package com.giedrius.forecastproject

import com.giedrius.forecastproject.forecast.ForecastFragment
import com.giedrius.forecastproject.forecast.ForecastModule
import com.giedrius.forecastproject.utils.scopes.FragmentScope
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class MainActivityModule {

    @FragmentScope
    @ContributesAndroidInjector(modules = [ForecastModule::class])
    abstract fun contributeForecastFragment(): ForecastFragment
}
