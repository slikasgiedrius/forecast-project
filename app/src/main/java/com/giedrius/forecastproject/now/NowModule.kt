package com.giedrius.forecastproject.now

import com.giedrius.forecastproject.now.list.NowAdapter
import com.giedrius.forecastproject.now.list.NowViewHolderFactory
import com.giedrius.forecastproject.now.network.NowService
import com.giedrius.forecastproject.database.LocationStorage
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
            locationStorage: LocationStorage,
            @Main mainScheduler: Scheduler,
            nowService: NowService
        ): NowContract.Presenter {
            return NowPresenter(
                mainScheduler,
                locationStorage,
                nowService
            )
        }

        @JvmStatic @Provides
        fun provideNowAdapter(): NowAdapter = NowAdapter(NowViewHolderFactory())
    }
}
