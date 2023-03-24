package com.mindbody.countrylist.data.di

import com.mindbody.countrylist.data.CountryNetworkDataSource
import com.mindbody.countrylist.data.CountryNetworkDataSourceImpl
import com.mindbody.countrylist.data.repository.CountryRepository
import com.mindbody.countrylist.data.repository.CountryRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
interface DataModule {
    @Binds
    fun CountryNetworkDataSourceImpl.binds(): CountryNetworkDataSource

    @Binds
    fun bindsCountryRepository(
        countryRepository: CountryRepositoryImpl
    ): CountryRepository
}
