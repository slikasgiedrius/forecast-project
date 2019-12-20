package com.giedrius.forecastproject

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.Toast
import androidx.core.content.ContextCompat
import com.giedrius.forecastproject.dagger.BaseDaggerActivity
import com.giedrius.forecastproject.utils.database.LocationStorage
import com.giedrius.forecastproject.now.NowFragment
import com.giedrius.forecastproject.hourly.HourlyFragment
import com.giedrius.forecastproject.daily.DailyFragment
import com.giedrius.forecastproject.search.Search
import com.giedrius.forecastproject.search.SearchService
import com.giedrius.forecastproject.utils.extensions.onRightDrawableClicked
import com.giedrius.forecastproject.utils.pager.ViewPagerAdapter
import com.giedrius.forecastproject.utils.schedulers.Main
import com.giedrius.forecastproject.utils.values.Constants
import io.reactivex.Scheduler
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.rxkotlin.addTo
import kotlinx.android.synthetic.main.activity_main.search_edit_text
import kotlinx.android.synthetic.main.activity_main.tabs
import kotlinx.android.synthetic.main.activity_main.viewPager
import javax.inject.Inject

class MainActivity : BaseDaggerActivity() {

    @Inject
    lateinit var locationStorage: LocationStorage

    @Inject
    lateinit var searchService: SearchService

    @Inject @field:Main lateinit var mainScheduler: Scheduler

    private val subscription = CompositeDisposable()

    override fun getLayoutId() = R.layout.activity_main

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initViewPager()
        initSearchBar()
    }

    override fun onDestroy() {
        super.onDestroy()
        subscription.dispose()
    }

    private fun initViewPager() {
        val adapter = ViewPagerAdapter(supportFragmentManager)
        adapter.addFragment(NowFragment(), getString(R.string.fragment_now))
        adapter.addFragment(HourlyFragment(), getString(R.string.fragment_hourly))
        adapter.addFragment(DailyFragment(), getString(R.string.fragment_forecast))
        viewPager.adapter = adapter
        viewPager.setOffscreenPageLimit(Constants.OFF_SCREEN_PAGE_LIMIT);
        tabs.setupWithViewPager(viewPager)
    }

    private fun initSearchBar() {
        val searchIconDrawable = ContextCompat.getDrawable(applicationContext, R.drawable.ic_search)
        val clearIconDrawable = ContextCompat.getDrawable(applicationContext, R.drawable.ic_clear)
        if (!locationStorage.getLocationName().equals("")){
            search_edit_text.setText(locationStorage.getLocationName())
            search_edit_text.setCompoundDrawablesWithIntrinsicBounds(null, null, searchIconDrawable, null)
            search_edit_text.onRightDrawableClicked {
                searchForCity(it.text.toString())
            }
        }

        search_edit_text.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable) {
                if (search_edit_text.text!!.count() > 0) {
                    search_edit_text.setCompoundDrawablesWithIntrinsicBounds(null, null, searchIconDrawable, null)
                    search_edit_text.onRightDrawableClicked {
                        searchForCity(it.text.toString())
                    }
                } else {
                    search_edit_text.setCompoundDrawablesWithIntrinsicBounds(null, null, clearIconDrawable, null)
                    search_edit_text.onRightDrawableClicked {
                        it.clearFocus()
                        it.setCompoundDrawablesWithIntrinsicBounds(null, null, null, null)
                    }
                }
            }

            override fun beforeTextChanged(s: CharSequence, start: Int, count: Int, after: Int) {
                if (search_edit_text.text!!.count() > 0) {
                    search_edit_text.setCompoundDrawablesWithIntrinsicBounds(null, null, searchIconDrawable, null)
                    search_edit_text.onRightDrawableClicked {
                        searchForCity(it.text.toString())
                    }
                } else {
                    search_edit_text.setCompoundDrawablesWithIntrinsicBounds(null, null, clearIconDrawable, null)
                    search_edit_text.onRightDrawableClicked {
                        it.clearFocus()
                        it.setCompoundDrawablesWithIntrinsicBounds(null, null, null, null)
                    }
                }
            }

            override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {}
        })

    }

    private fun searchForCity(query: String) {
        if (!locationStorage.getLocationName().equals(query)) {
            searchService.getSearchResults(BuildConfig.API_KEY, query)
                .observeOn(mainScheduler)
                .subscribe(::onDailyForecastsReceived, ::onDailyForecastsFailed)
                .addTo(subscription)
        }
    }

    private fun onDailyForecastsReceived(searchResult: List<Search>) {
        locationStorage.saveLocationKey(searchResult.first().Key.toString())
        locationStorage.saveLocationName(searchResult.first().englishName)
        initViewPager()
    }

    private fun onDailyForecastsFailed(throwable: Throwable) {
        Toast.makeText(applicationContext, throwable.message.toString(), Toast.LENGTH_LONG).show()
    }
}