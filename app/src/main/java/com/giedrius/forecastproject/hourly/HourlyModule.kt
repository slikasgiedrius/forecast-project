package com.giedrius.forecastproject.hourly

import com.giedrius.forecastproject.hourly.list.HourlyAdapter
import com.giedrius.forecastproject.hourly.list.HourlyViewHolderFactory
import com.giedrius.forecastproject.hourly.network.HourlyService
import com.giedrius.forecastproject.utils.database.LocationStorage
import com.giedrius.forecastproject.utils.schedulers.Main
import com.giedrius.forecastproject.utils.scopes.FragmentScope
import dagger.Module
import dagger.Provides
import io.reactivex.Scheduler

@Module
abstract class HourlyModule {

    @Module
    companion object {
        @FragmentScope
        @JvmStatic @Provides
        fun providePresenter(
            @Main mainScheduler: Scheduler,
            hourlyService: HourlyService,
            locationStorage: LocationStorage
        ): HourlyContract.Presenter {
            return HourlyPresenter(
                mainScheduler,
                hourlyService,
                locationStorage
            )
        }

        @JvmStatic @Provides
        fun provideHourlyAdapter(): HourlyAdapter = HourlyAdapter(HourlyViewHolderFactory())
    }
}
