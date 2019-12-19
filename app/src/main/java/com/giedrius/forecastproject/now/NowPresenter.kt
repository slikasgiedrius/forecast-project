package com.giedrius.forecastproject.now

import com.giedrius.forecastproject.BuildConfig
import com.giedrius.forecastproject.now.NowContract.View
import com.giedrius.forecastproject.now.network.CurrentForecast
import com.giedrius.forecastproject.now.network.NowService
import com.giedrius.forecastproject.utils.database.LocationStorage
import com.giedrius.forecastproject.utils.mvp.ViewPresenter
import com.giedrius.forecastproject.utils.values.Constants
import io.reactivex.Scheduler
import io.reactivex.rxkotlin.addTo

class NowPresenter(
    private val mainScheduler: Scheduler,
    private val nowService: NowService,
    private val locationStorage: LocationStorage
) : NowContract.Presenter, ViewPresenter<View>() {

    override fun onCreated() {
        nowService.getCurrentForecast(locationStorage.getLocation(), BuildConfig.API_KEY)
            .observeOn(mainScheduler)
            .subscribe(::onCurrentForecastReceived, ::onCurrentForecastFailed)
            .addTo(subscription)
    }

    private fun onCurrentForecastReceived(now: List<CurrentForecast>) {
        onView { bindCurrentForecast(now.first()) }
    }

    private fun onCurrentForecastFailed(throwable: Throwable) {
        onView { showError(throwable.localizedMessage) }
    }
}
