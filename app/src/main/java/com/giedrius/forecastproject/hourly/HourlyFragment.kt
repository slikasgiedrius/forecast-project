package com.giedrius.forecastproject.hourly

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.RecyclerView
import com.giedrius.forecastproject.R
import com.giedrius.forecastproject.dagger.BaseDaggerFragment
import com.giedrius.forecastproject.hourly.list.HourlyAdapter
import com.giedrius.forecastproject.hourly.network.Hourly
import kotlinx.android.synthetic.main.fragment_hourly.hourly_list
import javax.inject.Inject

class HourlyFragment : BaseDaggerFragment(), HourlyContract.View {

    @Inject
    lateinit var mPresenter: HourlyContract.Presenter
    @Inject
    lateinit var mAdapter: HourlyAdapter

    override fun getLayoutId() = R.layout.fragment_hourly

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
        hourly_list.addItemDecoration(DividerItemDecoration(requireContext(), RecyclerView.VERTICAL))
        hourly_list.setHasFixedSize(true)
        hourly_list.adapter = mAdapter
    }

    override fun displayHourlyForecast(hourly: List<Hourly>) {
        mAdapter.setAll(hourly)
    }

    override fun onDestroy() {
        mPresenter.dropView()
        super.onDestroy()
    }
}
