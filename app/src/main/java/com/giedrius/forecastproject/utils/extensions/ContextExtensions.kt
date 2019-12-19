package com.giedrius.forecastproject.utils.extensions

import android.content.Context
import android.content.res.Resources

fun Context.resIdByName(resIdName: String?): Int {
    resIdName?.let {
        return resources.getIdentifier(it, "drawable", packageName)
    }
    throw Resources.NotFoundException()
}