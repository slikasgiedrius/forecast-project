package com.giedrius.forecastproject.utils.network

import com.giedrius.forecastproject.hourly.network.HourlyService
import com.giedrius.forecastproject.now.network.NowService
import com.giedrius.forecastproject.utils.values.Constants
import com.giedrius.forecastproject.utils.schedulers.Io
import com.giedrius.forecastproject.weekly.network.WeeklyService
import dagger.Module
import dagger.Provides
import io.reactivex.Scheduler
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
abstract class NetworkModule {

    @Module
    companion object {

        @JvmStatic
        @Singleton
        @Provides
        fun provideRetrofit(client: OkHttpClient, @Io scheduler: Scheduler): Retrofit {
            return Retrofit.Builder()
                .baseUrl(Constants.BASE_URL)
                .client(client)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.createWithScheduler(scheduler))
                .build()
        }

        @JvmStatic
        @Provides
        fun provideOkHttpClient(): OkHttpClient {
            return OkHttpClient.Builder()
                .addInterceptor(HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY))
                .build()
        }

        @JvmStatic
        @Provides
        fun provideNowService(retrofit: Retrofit): NowService {
            return retrofit.create(NowService::class.java)
        }

        @JvmStatic
        @Provides
        fun provideHourlyService(retrofit: Retrofit): HourlyService {
            return retrofit.create(HourlyService::class.java)
        }

        @JvmStatic
        @Provides
        fun provideWeeklyService(retrofit: Retrofit): WeeklyService {
            return retrofit.create(WeeklyService::class.java)
        }
    }
}
