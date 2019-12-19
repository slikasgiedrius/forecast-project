package com.giedrius.forecastproject.forecast

import com.giedrius.forecastproject.repository.LocationStorage
import com.giedrius.forecastproject.forecast.list.ForecastAdapter
import com.giedrius.forecastproject.forecast.list.ForecastViewHolderFactory
import com.giedrius.forecastproject.forecast.network.ForecastService
import com.giedrius.forecastproject.utils.schedulers.Main
import com.giedrius.forecastproject.utils.scopes.FragmentScope
import dagger.Module
import dagger.Provides
import io.reactivex.Scheduler

@Module
abstract class ForecastModule {

    @Module
    companion object {
        @FragmentScope
        @JvmStatic @Provides
        fun providePresenter(
                locationStorage: LocationStorage,
                @Main mainScheduler: Scheduler,
                forecastService: ForecastService
        ): ForecastContract.Presenter {
            return ForecastPresenter(
                mainScheduler,
                locationStorage,
                forecastService
            )
        }

        @JvmStatic @Provides
        fun provideForecastsAdapter(): ForecastAdapter = ForecastAdapter(ForecastViewHolderFactory())
    }
}
