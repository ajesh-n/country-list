package com.mindbody.countrylist.data

import com.mindbody.countrylist.data.model.Country
import com.mindbody.countrylist.data.model.Province
import com.mindbody.countrylist.data.service.CountryService
import javax.inject.Inject

class CountryNetworkDataSourceImpl @Inject constructor(
    private val countryService: CountryService
) : CountryNetworkDataSource {
    override suspend fun getCountries(): Result<List<Country>> {
        return countryService.fetchCountries()
    }

    override suspend fun getProvinces(code: String): Result<List<Province>> {
        return countryService.fetchProvinces(code)
    }
}
