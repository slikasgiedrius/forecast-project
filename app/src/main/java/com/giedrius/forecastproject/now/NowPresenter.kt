package com.giedrius.forecastproject.now

import com.giedrius.forecastproject.BuildConfig
import com.giedrius.forecastproject.now.NowContract.View
import com.giedrius.forecastproject.now.network.Now
import com.giedrius.forecastproject.now.network.NowService
import com.giedrius.forecastproject.utils.database.LocationStorage
import com.giedrius.forecastproject.utils.mvp.ViewPresenter
import com.giedrius.forecastproject.utils.values.Constants
import io.reactivex.Scheduler
import io.reactivex.rxkotlin.addTo

class NowPresenter(
    private val mainScheduler: Scheduler,
    private val nowService: NowService
) : NowContract.Presenter, ViewPresenter<View>() {

    override fun onCreated() {
        nowService.getCurrentConditions(Constants.VILNIUS_LOCATION_KEY, BuildConfig.API_KEY)
            .observeOn(mainScheduler)
            .subscribe(::onCurrentForecastReceived, ::onCurrentForecastFailed)
            .addTo(subscription)
    }

    private fun onCurrentForecastReceived(now: List<Now>) {
        onView { bindCurrentForecast(now.first()) }
    }

    private fun onCurrentForecastFailed(throwable: Throwable) {
        onView { showError(throwable.localizedMessage) }
    }
}
