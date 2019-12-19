package com.giedrius.forecastproject.hourly

import com.giedrius.forecastproject.hourly.HourlyContract.View
import com.giedrius.forecastproject.hourly.network.Hourly
import com.giedrius.forecastproject.hourly.network.HourlyService
import com.giedrius.forecastproject.utils.database.LocationStorage
import com.giedrius.forecastproject.utils.mvp.ViewPresenter
import io.reactivex.Scheduler

class HourlyPresenter(
    private val mainScheduler: Scheduler,
    private val hourlyService: HourlyService
) : HourlyContract.Presenter, ViewPresenter<View>() {

    override fun onCreated() {
        //itWorks. Saving calls count
//        hourlyService.getHourlyForecast(Constants.VILNIUS_LOCATION_KEY, BuildConfig.API_KEY)
//            .observeOn(mainScheduler)
//            .subscribe(::onForecastsReceived, ::onForecastsFailed)
//            .addTo(subscription)
    }

    private fun onForecastsReceived(now: List<Hourly>) {
//        onView { populateForecasts(forecasts.toTypedArray()) }
    }

    private fun onForecastsFailed(throwable: Throwable) {
        onView { showError(throwable.localizedMessage) }
    }
}
