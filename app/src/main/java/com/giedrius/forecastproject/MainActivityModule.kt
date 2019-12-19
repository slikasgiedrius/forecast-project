package com.giedrius.forecastproject

import com.giedrius.forecastproject.hourly.HourlyFragment
import com.giedrius.forecastproject.hourly.HourlyModule
import com.giedrius.forecastproject.now.NowFragment
import com.giedrius.forecastproject.now.NowModule
import com.giedrius.forecastproject.utils.scopes.FragmentScope
import com.giedrius.forecastproject.weekly.WeeklyFragment
import com.giedrius.forecastproject.weekly.WeeklyModule
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class MainActivityModule {

    @FragmentScope
    @ContributesAndroidInjector(modules = [NowModule::class])
    abstract fun contributeNowFragment(): NowFragment

    @FragmentScope
    @ContributesAndroidInjector(modules = [HourlyModule::class])
    abstract fun contributeHourlyFragment(): HourlyFragment

    @FragmentScope
    @ContributesAndroidInjector(modules = [WeeklyModule::class])
    abstract fun contributeWeeklyFragment(): WeeklyFragment
}
