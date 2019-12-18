package com.giedrius.forecastproject.utils.extensions

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import com.giedrius.forecastproject.R

fun FragmentActivity.replaceFragment(fragment: Fragment, container: Int = R.id.fragmentContainer) {
    supportFragmentManager.beginTransaction()
        .replace(container, fragment)
        .commit()
}
