package com.giedrius.forecastproject.utils.mvp

interface BasePresenter<T> {
    fun takeView(view: T)
    fun dropView()
}
