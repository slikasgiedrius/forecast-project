package com.giedrius.forecastproject.hourly

import com.giedrius.forecastproject.hourly.network.Hourly
import com.giedrius.forecastproject.utils.mvp.BasePresenter

interface HourlyContract   {

    interface View {
        fun displayHourlyForecast(hourly: List<Hourly>)
        fun setList()
        fun showError(message: String)
    }

    interface Presenter : BasePresenter<View> {
        fun onCreated()
    }
}
