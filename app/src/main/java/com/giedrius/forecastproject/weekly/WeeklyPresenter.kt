package com.giedrius.forecastproject.weekly

import com.giedrius.forecastproject.BuildConfig
import com.giedrius.forecastproject.utils.mvp.ViewPresenter
import com.giedrius.forecastproject.utils.values.Constants
import com.giedrius.forecastproject.weekly.WeeklyContract.View
import com.giedrius.forecastproject.weekly.network.Weekly
import com.giedrius.forecastproject.weekly.network.WeeklyService
import io.reactivex.Scheduler
import io.reactivex.rxkotlin.addTo

class WeeklyPresenter (
    private val mainScheduler: Scheduler,
    private val weeklyService: WeeklyService
) : WeeklyContract.Presenter, ViewPresenter<View>() {

    override fun onCreated() {
//        weeklyService.getWeeklyForecast(Constants.VILNIUS_LOCATION_KEY, BuildConfig.API_KEY)
//            .observeOn(mainScheduler)
//            .subscribe(::onForecastsReceived, ::onForecastsFailed)
//            .addTo(subscription)
    }

    private fun onForecastsReceived(weeklyForecast: Weekly) {
        onView { setList() }
        onView { displayWeeklyForecast(weeklyForecast.dailyForecasts) }
    }

    private fun onForecastsFailed(throwable: Throwable) {
        onView { showError(throwable.localizedMessage) }
    }
}
