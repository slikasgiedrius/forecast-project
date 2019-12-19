package com.giedrius.forecastproject.daily

import com.giedrius.forecastproject.utils.schedulers.Main
import com.giedrius.forecastproject.utils.scopes.FragmentScope
import com.giedrius.forecastproject.daily.list.DailyAdapter
import com.giedrius.forecastproject.daily.list.DailyViewHolderFactory
import com.giedrius.forecastproject.daily.network.DailyService
import dagger.Module
import dagger.Provides
import io.reactivex.Scheduler

@Module
abstract class DailyModule {
    @Module
    companion object {
        @FragmentScope
        @JvmStatic @Provides
        fun providePresenter(
            @Main mainScheduler: Scheduler,
            dailyService: DailyService
        ): DailyContract.Presenter {
            return DailyPresenter(
                mainScheduler,
                dailyService
            )
        }

        @JvmStatic @Provides
        fun provideDailyAdapter(): DailyAdapter = DailyAdapter(DailyViewHolderFactory())
    }
}