package com.giedrius.forecastproject.weekly

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.RecyclerView
import com.giedrius.forecastproject.R
import com.giedrius.forecastproject.dagger.BaseDaggerFragment
import com.giedrius.forecastproject.weekly.list.WeeklyAdapter
import com.giedrius.forecastproject.weekly.network.DailyForecasts
import kotlinx.android.synthetic.main.fragment_weekly.weekly_forecast_list
import javax.inject.Inject

class WeeklyFragment : BaseDaggerFragment(), WeeklyContract.View {

    @Inject
    lateinit var mPresenter: WeeklyContract.Presenter
    @Inject
    lateinit var mAdapter: WeeklyAdapter

    override fun getLayoutId() = R.layout.fragment_weekly

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
        weekly_forecast_list.addItemDecoration(DividerItemDecoration(requireContext(), RecyclerView.VERTICAL))
        weekly_forecast_list.setHasFixedSize(true)
        weekly_forecast_list.adapter = mAdapter
    }

    override fun displayWeeklyForecast(dailyForecasts: List<DailyForecasts>) {
        mAdapter.setAll(dailyForecasts)
    }

    override fun onDestroy() {
        mPresenter.dropView()
        super.onDestroy()
    }

}
