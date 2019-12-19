package com.giedrius.forecastproject.weekly

import com.giedrius.forecastproject.utils.database.LocationStorage
import com.giedrius.forecastproject.utils.mvp.ViewPresenter
import com.giedrius.forecastproject.weekly.WeeklyContract.View
import com.giedrius.forecastproject.weekly.network.Weekly
import com.giedrius.forecastproject.weekly.network.WeeklyService
import io.reactivex.Scheduler

class WeeklyPresenter (
    private val mainScheduler: Scheduler,
    private val weeklyService: WeeklyService
) : WeeklyContract.Presenter, ViewPresenter<View>() {

    override fun onCreated() {
        //itWorks. Saving calls count
//        weeklyService.getWeeklyForecast(Constants.VILNIUS_LOCATION_KEY, BuildConfig.API_KEY)
//            .observeOn(mainScheduler)
//            .subscribe(::onForecastsReceived, ::onForecastsFailed)
//            .addTo(subscription)
    }

    private fun onForecastsReceived(now: Weekly) {
//        onView { populateForecasts(forecasts.toTypedArray()) }
    }

    private fun onForecastsFailed(throwable: Throwable) {
        onView { showError(throwable.localizedMessage) }
    }
}
