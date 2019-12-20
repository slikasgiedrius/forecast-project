package com.giedrius.forecastproject.hourly

import com.giedrius.forecastproject.BuildConfig
import com.giedrius.forecastproject.hourly.HourlyContract.View
import com.giedrius.forecastproject.hourly.network.Hourly
import com.giedrius.forecastproject.hourly.network.HourlyService
import com.giedrius.forecastproject.utils.database.LocationStorage
import com.giedrius.forecastproject.utils.mvp.ViewPresenter
import com.giedrius.forecastproject.utils.values.Constants
import io.reactivex.Scheduler
import io.reactivex.rxkotlin.addTo

class HourlyPresenter(
    private val mainScheduler: Scheduler,
    private val hourlyService: HourlyService,
    private val locationStorage: LocationStorage
) : HourlyContract.Presenter, ViewPresenter<View>() {

    override fun onCreated() {
        if (!locationStorage.getLocationKey().equals("")) {
            hourlyService.getHourlyForecast(locationStorage.getLocationKey(), BuildConfig.API_KEY)
                .observeOn(mainScheduler)
                .subscribe(::onHourlyForecastsReceived, ::onHourlyForecastsFailed)
                .addTo(subscription)
        }
    }

    private fun onHourlyForecastsReceived(hourly: List<Hourly>) {
        onView { setList() }
        onView { displayHourlyForecast(hourly) }
    }

    private fun onHourlyForecastsFailed(throwable: Throwable) {
        onView { showError(throwable.localizedMessage) }
    }
}
