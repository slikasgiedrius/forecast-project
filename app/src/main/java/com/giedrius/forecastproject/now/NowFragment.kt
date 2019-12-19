package com.giedrius.forecastproject.now

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
import com.giedrius.forecastproject.now.network.Now
import com.giedrius.forecastproject.utils.extensions.resIdByName
import com.giedrius.forecastproject.utils.values.Constants
import dagger.Module
import kotlinx.android.synthetic.main.fragment_forecasts.forecastList
import kotlinx.android.synthetic.main.fragment_now.imageView2
import javax.inject.Inject

class NowFragment : BaseDaggerFragment(), NowContract.View {

    @Inject lateinit var mPresenter: NowContract.Presenter

    override fun getLayoutId() = R.layout.fragment_now

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

    override fun bindCurrentForecast(now: Now) {
        val image: Int = context!!.resIdByName("ic_${now.weatherIcon}")
        imageView2.setBackgroundResource(image)
    }

    override fun onDestroy() {
        mPresenter.dropView()
        super.onDestroy()
    }

}
