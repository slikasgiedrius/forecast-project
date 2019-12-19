package com.giedrius.forecastproject.hourly

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.RecyclerView
import com.giedrius.forecastproject.R
import com.giedrius.forecastproject.dagger.BaseDaggerFragment
import com.giedrius.forecastproject.hourly.list.HourlyAdapter
import com.giedrius.forecastproject.utils.values.Constants
import kotlinx.android.synthetic.main.fragment_forecasts.forecastList
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
        forecastList.addItemDecoration(DividerItemDecoration(requireContext(), RecyclerView.VERTICAL))
        forecastList.setHasFixedSize(true)
        forecastList.adapter = mAdapter
    }

    override fun populateForecasts() {
//        mAdapter.setAll(forecasts.toList())
    }

    override fun onDestroy() {
        mPresenter.dropView()
        super.onDestroy()
    }
}