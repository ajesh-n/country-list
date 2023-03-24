package com.mindbody.countrylist.data.repository

import com.mindbody.countrylist.data.CountryNetworkDataSource
import com.mindbody.countrylist.data.model.Country
import com.mindbody.countrylist.data.model.Province
import javax.inject.Inject

class CountryRepositoryImpl @Inject constructor(
    private val countryNetworkDataSource: CountryNetworkDataSource
) : CountryRepository {
    override suspend fun getCountries(): Result<List<Country>> =
        countryNetworkDataSource.getCountries()

    override suspend fun getProvincesBy(countryCode: String): Result<List<Province>> =
        countryNetworkDataSource.getProvinces(countryCode)
}
