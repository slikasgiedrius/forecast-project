package com.giedrius.forecastproject.app

import com.giedrius.forecastproject.MainActivity
import com.giedrius.forecastproject.MainActivityModule
import com.giedrius.forecastproject.utils.scopes.ActivityScope
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class AppContributorsModule {

    @ActivityScope
    @ContributesAndroidInjector(modules = [MainActivityModule::class])
    abstract fun contributeMainActivity(): MainActivity
}
