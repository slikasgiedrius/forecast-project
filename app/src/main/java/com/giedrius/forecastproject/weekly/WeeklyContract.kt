package com.giedrius.forecastproject.weekly

import com.giedrius.forecastproject.utils.mvp.BasePresenter

interface WeeklyContract   {

    interface View {
        fun populateForecasts()
        fun setList()
        fun showError(message: String)
    }

    interface Presenter : BasePresenter<View> {
        fun onCreated()
    }
}