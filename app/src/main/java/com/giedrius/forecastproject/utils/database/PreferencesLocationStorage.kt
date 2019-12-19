package com.giedrius.forecastproject.utils.database

import android.content.SharedPreferences
import com.giedrius.forecastproject.utils.values.Constants

class PreferencesLocationStorage(
        private val sharedPreferences: SharedPreferences
) : LocationStorage {

    override fun removeLocation() {
        sharedPreferences.edit().remove(Constants.KEY_LOCATION).apply()
    }

    override fun saveLocation(locationKey: String) {
        sharedPreferences.edit().putString(Constants.KEY_LOCATION, locationKey).apply()
    }

    override fun getLocation(): String = sharedPreferences.getString(Constants.KEY_LOCATION, Constants.EMPTY_LOCATION)!!
}
