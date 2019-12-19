package com.giedrius.forecastproject.weekly

import com.giedrius.forecastproject.utils.database.LocationStorage
import com.giedrius.forecastproject.utils.schedulers.Main
import com.giedrius.forecastproject.utils.scopes.FragmentScope
import com.giedrius.forecastproject.weekly.list.WeeklyAdapter
import com.giedrius.forecastproject.weekly.list.WeeklyViewHolderFactory
import com.giedrius.forecastproject.weekly.network.WeeklyService
import dagger.Module
import dagger.Provides
import io.reactivex.Scheduler

@Module
abstract class WeeklyModule {
    @Module
    companion object {
        @FragmentScope
        @JvmStatic @Provides
        fun providePresenter(
            @Main mainScheduler: Scheduler,
            weeklyService: WeeklyService
        ): WeeklyContract.Presenter {
            return WeeklyPresenter(
                mainScheduler,
                weeklyService
            )
        }

        @JvmStatic @Provides
        fun provideWeeklyAdapter(): WeeklyAdapter = WeeklyAdapter(WeeklyViewHolderFactory())
    }
}