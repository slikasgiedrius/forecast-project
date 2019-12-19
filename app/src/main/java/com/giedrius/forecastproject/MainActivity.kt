package com.giedrius.forecastproject

import android.os.Bundle
import com.giedrius.forecastproject.dagger.BaseDaggerActivity
import com.giedrius.forecastproject.repository.LocationStorage
import com.giedrius.forecastproject.forecast.ForecastFragment
import com.giedrius.forecastproject.utils.extensions.replaceFragment
import javax.inject.Inject

class MainActivity : BaseDaggerActivity() {

    @Inject
    lateinit var mLocationStorage: LocationStorage

    override fun getLayoutId() = R.layout.activity_main

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if (savedInstanceState == null) {
            replaceFragment(ForecastFragment.newInstance())
        }
    }
}