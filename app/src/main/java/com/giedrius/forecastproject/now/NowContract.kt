package com.giedrius.forecastproject.now

import com.giedrius.forecastproject.now.network.CurrentForecast
import com.giedrius.forecastproject.utils.mvp.BasePresenter

interface NowContract {

    interface View {
        fun bindCurrentForecast(currentForecast: CurrentForecast)
        fun showError(message: String)
    }

    interface Presenter : BasePresenter<View> {
        fun onCreated()
    }
}
