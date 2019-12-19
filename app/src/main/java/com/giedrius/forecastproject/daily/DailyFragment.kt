package com.giedrius.forecastproject.daily

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.RecyclerView
import com.giedrius.forecastproject.R
import com.giedrius.forecastproject.dagger.BaseDaggerFragment
import com.giedrius.forecastproject.daily.list.DailyAdapter
import com.giedrius.forecastproject.daily.network.DailyForecasts
import kotlinx.android.synthetic.main.fragment_daily.daily_forecast_list
import javax.inject.Inject

class DailyFragment : BaseDaggerFragment(), DailyContract.View {

    @Inject
    lateinit var mPresenter: DailyContract.Presenter
    @Inject
    lateinit var mAdapter: DailyAdapter

    override fun getLayoutId() = R.layout.fragment_daily

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mPresenter.takeView(this)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        mPresenter.onCreated()
    }

    override fun showError(message: String) {
        Toast.makeText(requireContext(), message, Toast.LENGTH_LONG).show()
    }

    override fun setList() {
        daily_forecast_list.addItemDecoration(DividerItemDecoration(requireContext(), RecyclerView.VERTICAL))
        daily_forecast_list.setHasFixedSize(true)
        daily_forecast_list.adapter = mAdapter
    }

    override fun displayDailyForecast(dailyForecasts: List<DailyForecasts>) {
        mAdapter.setAll(dailyForecasts)
    }

    override fun onDestroy() {
        mPresenter.dropView()
        super.onDestroy()
    }

}
