package com.giedrius.forecastproject

import android.os.Bundle
import com.giedrius.forecastproject.dagger.BaseDaggerActivity
import com.giedrius.forecastproject.utils.database.LocationStorage
import com.giedrius.forecastproject.now.NowFragment
import com.giedrius.forecastproject.hourly.HourlyFragment
import com.giedrius.forecastproject.weekly.WeeklyFragment
import com.giedrius.forecastproject.utils.pager.ViewPagerAdapter
import kotlinx.android.synthetic.main.activity_main.tabs
import kotlinx.android.synthetic.main.activity_main.toolbar
import kotlinx.android.synthetic.main.activity_main.viewPager
import javax.inject.Inject

class MainActivity : BaseDaggerActivity() {

    @Inject
    lateinit var mLocationStorage: LocationStorage

    override fun getLayoutId() = R.layout.activity_main

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setSupportActionBar(toolbar)
        initViewPager()
    }

    private fun initViewPager() {
        val adapter = ViewPagerAdapter(supportFragmentManager)
        adapter.addFragment(NowFragment(), getString(R.string.fragment_now))
        adapter.addFragment(HourlyFragment(), getString(R.string.fragment_hourly))
        adapter.addFragment(WeeklyFragment(), getString(R.string.fragment_forecast))
        viewPager.adapter = adapter
        tabs.setupWithViewPager(viewPager)
    }
}