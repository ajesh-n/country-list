package com.mindbody.countrylist.data.di

import com.mindbody.countrylist.data.retrofit.ResultCallAdapterFactory
import com.mindbody.countrylist.data.service.CountryService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

@InstallIn(SingletonComponent::class)
@Module
object NetworkModule {
    private const val base_url =
        "https://countries-ed35c-default-rtdb.asia-southeast1.firebasedatabase.app"

    @Singleton
    @Provides
    fun provideRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl(base_url)
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(ResultCallAdapterFactory())
            .build()
    }

    @Singleton
    @Provides
    fun provideApiService(retrofit: Retrofit): CountryService {
        return retrofit.create(CountryService::class.java)
    }

}