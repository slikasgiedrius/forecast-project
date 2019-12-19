package com.giedrius.forecastproject.weekly

import com.giedrius.forecastproject.utils.mvp.BasePresenter
import com.giedrius.forecastproject.weekly.network.DailyForecasts

interface WeeklyContract   {

    interface View {
        fun displayWeeklyForecast(dailyForecasts: List<DailyForecasts>)
        fun setList()
        fun showError(message: String)
    }

    interface Presenter : BasePresenter<View> {
        fun onCreated()
    }
}