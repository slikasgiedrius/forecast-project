package com.giedrius.forecastproject.daily

import com.giedrius.forecastproject.utils.mvp.ViewPresenter
import com.giedrius.forecastproject.daily.DailyContract.View
import com.giedrius.forecastproject.daily.network.Daily
import com.giedrius.forecastproject.daily.network.DailyService
import io.reactivex.Scheduler

class DailyPresenter (
    private val mainScheduler: Scheduler,
    private val dailyService: DailyService
) : DailyContract.Presenter, ViewPresenter<View>() {

    override fun onCreated() {
//        dailyService.getDailyForecast(Constants.VILNIUS_LOCATION_KEY, BuildConfig.API_KEY)
//            .observeOn(mainScheduler)
//            .subscribe(::onDailyForecastsReceived, ::onDailyForecastsFailed)
//            .addTo(subscription)
    }

    private fun onDailyForecastsReceived(dailyForecast: Daily) {
        onView { setList() }
        onView { displayDailyForecast(dailyForecast.dailyForecasts) }
    }

    private fun onDailyForecastsFailed(throwable: Throwable) {
        onView { showError(throwable.localizedMessage) }
    }
}
