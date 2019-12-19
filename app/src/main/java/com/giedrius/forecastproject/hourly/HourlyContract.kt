package com.giedrius.forecastproject.hourly

import com.giedrius.forecastproject.utils.mvp.BasePresenter

interface HourlyContract   {

    interface View {
        fun populateForecasts()
        fun setList()
        fun showError(message: String)
    }

    interface Presenter : BasePresenter<View> {
        fun onCreated()
    }
}
