package com.giedrius.forecastproject.now

import com.giedrius.forecastproject.now.network.Now
import com.giedrius.forecastproject.utils.mvp.BasePresenter

interface NowContract  {

    interface View {
        fun bindCurrentForecast(now: Now)
        fun showError(message: String)
    }

    interface Presenter : BasePresenter<View> {
        fun onCreated()
    }
}
