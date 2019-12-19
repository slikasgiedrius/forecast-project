package com.giedrius.forecastproject.now

import com.giedrius.forecastproject.now.network.NowService
import com.giedrius.forecastproject.utils.schedulers.Main
import com.giedrius.forecastproject.utils.scopes.FragmentScope
import dagger.Module
import dagger.Provides
import io.reactivex.Scheduler

@Module
abstract class NowModule {

    @Module
    companion object {
        @FragmentScope
        @JvmStatic @Provides
        fun providePresenter(
            @Main mainScheduler: Scheduler,
            nowService: NowService
        ): NowContract.Presenter {
            return NowPresenter(
                mainScheduler,
                nowService
            )
        }
    }
}
