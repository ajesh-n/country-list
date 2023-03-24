package com.mindbody.countrylist.domain.usecases

import com.mindbody.countrylist.domain.entity.CountryEntity

interface GetCountriesUseCase {
    suspend fun getCountries(): Result<List<CountryEntity>>
}
