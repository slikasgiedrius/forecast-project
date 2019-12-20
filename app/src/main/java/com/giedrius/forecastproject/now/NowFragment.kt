package com.giedrius.forecastproject.now

import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.giedrius.forecastproject.R
import com.giedrius.forecastproject.dagger.BaseDaggerFragment
import com.giedrius.forecastproject.now.network.CurrentForecast
import com.giedrius.forecastproject.utils.extensions.resIdByName
import kotlinx.android.synthetic.main.fragment_now.iw_weather_conditions_image
import kotlinx.android.synthetic.main.fragment_now.tv_temperature
import kotlinx.android.synthetic.main.fragment_now.tv_weather_description
import javax.inject.Inject

class NowFragment : BaseDaggerFragment(), NowContract.View {

    @Inject
    lateinit var mPresenter: NowContract.Presenter

    override fun getLayoutId() = R.layout.fragment_now

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mPresenter.takeView(this)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        mPresenter.onCreated()
    }

    override fun onDestroy() {
        mPresenter.dropView()
        super.onDestroy()
    }

    override fun bindCurrentForecast(currentForecast: CurrentForecast) {
        val image: Int = context!!.resIdByName("ic_${currentForecast.weatherIcon}")
        iw_weather_conditions_image.setBackgroundResource(image)
        tv_temperature.text = "${currentForecast.temperature.metric.value} ${currentForecast.temperature.metric.unit}"
        tv_weather_description.text = currentForecast.weatherText
    }

    override fun showError(message: String) {
        Toast.makeText(requireContext(), message, Toast.LENGTH_LONG).show()
    }
}
