package com.giedrius.forecastproject.app

import com.giedrius.forecastproject.utils.network.NetworkModule
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        AndroidSupportInjectionModule::class,
        AppContributorsModule::class,
        NetworkModule::class,
        AppModule::class
    ]
)

interface AppComponent : AndroidInjector<BaseApplication> {

    @Component.Builder
    abstract class Builder : AndroidInjector.Builder<BaseApplication>()
}
