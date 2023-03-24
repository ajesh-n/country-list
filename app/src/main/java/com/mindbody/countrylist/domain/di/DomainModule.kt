package com.mindbody.countrylist.domain.di

import com.mindbody.countrylist.domain.usecases.GetCountriesUseCase
import com.mindbody.countrylist.domain.usecases.GetCountriesUseCaseImpl
import com.mindbody.countrylist.domain.usecases.GetProvincesByCountryUseCase
import com.mindbody.countrylist.domain.usecases.GetProvincesByCountryUseCaseImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
interface DomainModule {
    @Binds
    fun GetCountriesUseCaseImpl.bind(): GetCountriesUseCase

    @Binds
    fun GetProvincesByCountryUseCaseImpl.bindProvinces(): GetProvincesByCountryUseCase
}
