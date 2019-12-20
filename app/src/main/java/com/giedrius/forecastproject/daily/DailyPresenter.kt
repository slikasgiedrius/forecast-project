package com.giedrius.forecastproject.daily

import com.giedrius.forecastproject.BuildConfig
import com.giedrius.forecastproject.utils.mvp.ViewPresenter
import com.giedrius.forecastproject.daily.DailyContract.View
import com.giedrius.forecastproject.daily.network.Daily
import com.giedrius.forecastproject.daily.network.DailyService
import com.giedrius.forecastproject.utils.database.LocationStorage
import io.reactivex.Scheduler
import io.reactivex.rxkotlin.addTo

class DailyPresenter(
    private val mainScheduler: Scheduler,
    private val dailyService: DailyService,
    private val locationStorage: LocationStorage
) : DailyContract.Presenter, ViewPresenter<View>() {

    override fun onCreated() {
        if (!locationStorage.getLocationKey().equals("")) {
            dailyService.getDailyForecast(locationStorage.getLocationKey(), BuildConfig.API_KEY)
                .observeOn(mainScheduler)
                .subscribe(::onDailyForecastsReceived, ::onDailyForecastsFailed)
                .addTo(subscription)
        }
    }

    private fun onDailyForecastsReceived(dailyForecast: Daily) {
        onView { setList() }
        onView { displayDailyForecast(dailyForecast.dailyForecasts) }
    }

    private fun onDailyForecastsFailed(throwable: Throwable) {
        onView { showError(throwable.localizedMessage) }
    }
}
