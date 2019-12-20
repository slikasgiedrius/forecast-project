package com.giedrius.forecastproject.utils.database

import android.content.SharedPreferences
import com.giedrius.forecastproject.utils.values.Constants

class PreferencesLocationStorage(
    private val sharedPreferences: SharedPreferences
) : LocationStorage {

    override fun saveLocationKey(locationKey: String) {
        sharedPreferences.edit().putString(Constants.KEY_LOCATION, locationKey).apply()
    }

    override fun getLocationKey(): String =
        sharedPreferences.getString(Constants.KEY_LOCATION, Constants.EMPTY_LOCATION)!!

    override fun saveLocationName(locationName: String) {
        sharedPreferences.edit().putString(Constants.NAME_LOCATION, locationName).apply()
    }

    override fun getLocationName(): String =
        sharedPreferences.getString(Constants.NAME_LOCATION, Constants.EMPTY_LOCATION)!!
}
