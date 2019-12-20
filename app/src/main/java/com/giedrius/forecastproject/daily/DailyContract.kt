package com.giedrius.forecastproject.daily

import com.giedrius.forecastproject.utils.mvp.BasePresenter
import com.giedrius.forecastproject.daily.network.DailyForecasts

interface DailyContract {

    interface View {
        fun displayDailyForecast(dailyForecasts: List<DailyForecasts>)
        fun setList()
        fun showError(message: String)
    }

    interface Presenter : BasePresenter<View> {
        fun onCreated()
    }
}